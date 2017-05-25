package com.ciber.admin.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.ciber.admin.dao.OverAllReportDAOImpl;
import com.ciber.admin.form.ApplicationModel;
import com.ciber.admin.uploadxls.UploadManagerData;
import com.ciber.beans.EmployeeDetails;
import com.ciber.beans.EmployeeList;
import com.ciber.beans.ExcelBean;
import com.ciber.beans.ImprovementOptions;
import com.ciber.beans.MgrPeerInfo;
import com.ciber.beans.Review;
import com.ciber.beans.SurveyBean;
import com.ciber.beans.User;
import com.ciber.charts.bean.DataBean;
import com.ciber.charts.service.ChartService;
import com.ciber.converter.UsertoPeersInfoConverter;
import com.ciber.dao.DaoFactory;
import com.ciber.mail.SendMailThread;
import com.ciber.service.JDBCService;
import com.google.gson.Gson;

@SuppressWarnings("deprecation")
public class AdminApplicationAction extends DispatchAction {
	static EmployeeList employeeList = new EmployeeList();
	JDBCService jdbcService = new JDBCService();
	private final static String SUCCESS = "success";
	ActionErrors errors = new ActionErrors();
	
	public ActionForward getManagerInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			response.setContentType("application/json");
			String query = request.getParameter("name");
			System.out.println("Data from ajax call " + query);
			List<EmployeeList> names=DaoFactory.getLoginDao().getUsers(query);
			EmployeeDetails empInfo = UsertoPeersInfoConverter.converter(names);
			String searchList = new Gson().toJson(empInfo);
			System.out.println(searchList);
			response.getWriter().write(searchList);
			return null;
	}
	
	public ActionForward updateManagerInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			response.setContentType("application/json");
			
			EmployeeDetails employeeInfo=new EmployeeDetails();
			employeeInfo.setPeer1Email(request.getParameter("peer1Email"));
			employeeInfo.setPeer2Email(request.getParameter("peer2Email"));
			employeeInfo.setCrossFunctionalEmail(request.getParameter("crossfunctionEmail"));
			employeeInfo.setItEmail(request.getParameter("itEmail"));
			employeeInfo.setHrbpEmail(request.getParameter("hrEmail"));
			employeeInfo.setAdminEmail(request.getParameter("adminEmail"));
			employeeInfo.setQmoEmail(request.getParameter("qmoEmail"));
			employeeInfo.setFinanceEmail(request.getParameter("financeEmail"));
			employeeInfo.setRequitmentEmail(request.getParameter("recruitmentEmail"));
			employeeInfo.setRmgEmail(request.getParameter("rmgEmail"));
			employeeInfo.setEmpId(request.getParameter("empID"));
			int i=DaoFactory.getUpdateManagerInfoDAO().updateManagerInfoUI(employeeInfo);
			String success="Updated successfully";
			if(i==0){
				success="Data not updated,Please contact support...";
			}
			
			
			String searchList = new Gson().toJson(success);
			System.out.println(searchList);
			response.getWriter().write(searchList);
			return null;
	}
	
	public ActionForward stop(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (new JDBCService().stopApplication(request.getParameter("appId"))) {
			request.getSession().removeAttribute("currentApp");
			request.getSession().setAttribute("currentApp",new JDBCService().currentApplications(new User()));
		} else
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"error.stop.failed"));

		return mapping.findForward(SUCCESS);
	}
	
	public ActionForward extend(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(SUCCESS);
	}

	
	public ActionForward feedBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String employeeno=request.getParameter("employeeno");
		if(employeeno==null){
			User user=(User)request.getSession().getAttribute("user");
			employeeno=user.getEmployeeId();
		}
		ArrayList<ApplicationModel> viewFeedBack = new JDBCService()
					.viewFeedBack(employeeno.trim());
			request.getSession().setAttribute("empId", employeeno);
			request.getSession().removeAttribute("ViewFeedBack");
			request.getSession().setAttribute("ViewFeedBack", viewFeedBack);
			return mapping.findForward("viewFeedBack");
	}
	
	public ActionForward viewSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String appId = request.getParameter("appId");
		String surveyName = request.getParameter("appName");
		User user=(User)request.getSession().getAttribute("user");
		String empLevel = (String)request.getSession().getAttribute("empLevel");
		String msg="viewSurveyMng";
		if(surveyName.contains(user.getUserId())){
			 msg="viewSurvey";
		}
		OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
		ExcelBean bean = overAllReportDao.getReports(appId,empLevel);
		String employeeID = overAllReportDao.getEmployee(appId);
		List<EmployeeList> empoyeeList = jdbcService.getUsers(employeeID);
		List<ImprovementOptions> improvementSelectOptions = jdbcService.getImprovementOptions();
		
		bean.setSurveyId(appId);
		bean.setSurveyName(surveyName);
		request.getSession().removeAttribute("viewSurvey");
		request.getSession().removeAttribute("ImprovementOptions");
		request.getSession().setAttribute("ImprovementOptions", improvementSelectOptions);
		if(bean.getAnsbean()!=null && !bean.getAnsbean().isEmpty()){
			if(empoyeeList.size()>5){
				request.getSession().setAttribute("reporteeInfo", empoyeeList);
			}
			request.getSession().setAttribute("viewSurvey", bean);
			request.getSession().setAttribute("ansSize", bean.getAnsbean().size());
		}
		return mapping.findForward(msg);
	}
	
	public ActionForward reviewSubmit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("done....");
		response.setContentType("application/json");
		Integer ansSize=(Integer)request.getSession().getAttribute("ansSize");
		String surveyId=request.getParameter("surveyId");
		for(int i=0;i<3;i++){
			String comments=request.getParameter("comments"+i);
			String comptency=request.getParameter("comptency"+i);
			String subCompetency=request.getParameter("subCompetency"+i);
			String percent=request.getParameter("rating"+i);
			String questionNo=request.getParameter("questionNo"+i);
			String ImprovementSelectID=request.getParameter("ImprovementSelectID"+i);
			Review review=new Review(surveyId,comptency,subCompetency,comments,percent,questionNo);
			review.setImprovementSelectID(ImprovementSelectID);
		    DaoFactory.getAdminJDBCDao().addReview(review);
		}
		DaoFactory.getAdminJDBCDao().updateApplication(surveyId);
		
		String searchList = new Gson().toJson("Review upadated successfully");
		System.out.println(searchList);
		response.getWriter().write(searchList);
		return null;
	}
	
	

	    public ActionForward linechart1(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
	    	 String empid=request.getParameter("empId");
	    	 ArrayList<ApplicationModel> viewFeedBack = new JDBCService()
				.viewFeedBack(empid);
	    	 DataBean bean=new DataBean();
	    	 if(!viewFeedBack.isEmpty() && viewFeedBack.size()>=2){
	    		 ApplicationModel survey1=viewFeedBack.get(0);
	    		 ApplicationModel survey2=viewFeedBack.get(1);
	    		 if("Reviewed".equals(survey1.getCompletedFlag()) || "Reviewed".equals(survey2.getCompletedFlag())){
	    			 ChartService chartService=new ChartService();
	    	    	 bean= chartService.getLineChartData1(survey1,survey2);
	    	    	 String searchList = new Gson().toJson(bean);
	    	    	 response.getWriter().write(searchList);
	    	    	 System.out.println(searchList);
	    				
	    		 }else{
	    			 String searchList = new Gson().toJson(new DataBean("Atleast one reflection should be reviewed status"));
	    			 response.getWriter().write(searchList);
	    	    	 System.out.println(searchList);
	    	    	 System.out.println(searchList);
	    			 	
	    		 }
	    		
	    		 
	    	 }else{
    			 String searchList = new Gson().toJson(new DataBean("Minimum two Reflection required to compare"));
    			 response.getWriter().write(searchList);
    	    	 System.out.println(searchList); 
	    	 }
	    	 	
				
				return null;
	    	
		}
	 
	    
	public ActionForward viewOverALLSurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String empLevel = request.getParameter("level");
		String empComp = request.getParameter("comp");
		request.getSession().setAttribute("empLevel", empLevel);
		request.getSession().setAttribute("empComp", empComp);
		User userDetails = (User)request.getSession().getAttribute("user");
		OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
		ExcelBean bean = overAllReportDao.getOverALLReports(empLevel,empComp,userDetails);
		bean.setEmpLevel(empLevel);
		request.getSession().removeAttribute("viewSurvey");
		if(bean.getAnsbean()!=null && !bean.getAnsbean().isEmpty()){
			bean.setSurveyId(null);
			bean.setSurveyName(null);
		request.getSession().setAttribute("viewSurvey", bean);
		}
		return mapping.findForward("viewSurveyMng");
	}
	
	public ActionForward viewCompetency(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String empLevel = request.getParameter("level");
		String empComp = request.getParameter("comp");
		request.getSession().setAttribute("empLevel", empLevel);
		request.getSession().setAttribute("empComp", empComp);
		OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
		User userDetails = (User)request.getSession().getAttribute("user");
		ExcelBean bean = overAllReportDao.getCompetencyReport(empLevel,empComp,userDetails);
		bean.setEmpLevel(empLevel);
		request.getSession().removeAttribute("viewSurvey");
		request.getSession().removeAttribute("viewSurveyMng");
		request.getSession().removeAttribute("competencyView");
		if(bean.getAnsbean()!=null && !bean.getAnsbean().isEmpty()){
			bean.setSurveyId(null);
			bean.setSurveyName(null);
			request.getSession().setAttribute("competencyView", bean);
		}
		return mapping.findForward("competencyView");
	}

	public ActionForward viewRecent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().removeAttribute("recentApp");
		ArrayList<ApplicationModel> recentApp = new JDBCService()
				.viewRecentApplication(request.getParameter("startDate"),
						request.getParameter("endDate"));

		request.getSession().setAttribute("recentApp", recentApp);
		return mapping.findForward("viewRecent");
	}
	
	public ActionForward veiwReporties(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	User user=(User)request.getSession().getAttribute("user");
	String employeeno=request.getParameter("employeeno");
	if(employeeno==null){
		employeeno=user.getEmployeeId();
	}
		List<User> recentApp = new JDBCService()
				.getReportiesDetails(employeeno.trim());
		request.getSession().removeAttribute("reporties");
		request.getSession().setAttribute("reporties", recentApp);
		return mapping.findForward("veiwReporties");
	}

	public ActionForward addApp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String appName = request.getParameter("appName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String appType ="Survey";
		String maskId = request.getParameter("maskId");
		String openToall = request.getParameter("dispId");
		String empNo = request.getParameter("empNo");
		String showCount = request.getParameter("showCount");
		boolean showflag=false;
		if(showCount!=null && !showCount.isEmpty()){
			showflag=true;
		}
		ActionErrors errors = new ActionErrors();
	
		String url=request.getRequestURL().toString().replace(request.getRequestURI(),request.getContextPath());

				List<EmployeeList> empoyeeList = jdbcService.getUsers(empNo);
				if(empoyeeList==null || empoyeeList.isEmpty()){
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
							"error.app.users.creation"));
					request.setAttribute(Globals.ERROR_KEY, errors);
					return mapping.findForward("failureAdd");
				}
				User user=(User)request.getSession().getAttribute("user");
				SurveyBean bean=new SurveyBean(appName,startDate, endDate, appType, maskId, openToall,empNo,showflag);
				
				int appId = new JDBCService().addApplication(bean);
				if(bean.getSurveyCreated()==null){
				request.getSession().setAttribute("applicationId", appId);
				request.getSession().setAttribute("appTypeCheck", appType);
				boolean isusersAdd = addUsers(empoyeeList,appId,url,user);

				if (!isusersAdd) {
					request.setAttribute("message", "Reflection sucessfully created...");
					return mapping.findForward("addApplication");
				}else{
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
							"error.app.creation.failed"));
					request.setAttribute(Globals.ERROR_KEY, errors);
					return mapping.findForward("failureAdd");
				}
				}else{
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
							"error.app.creation.failed"));
					request.setAttribute(Globals.ERROR_KEY, errors);
					return mapping.findForward("failureAdd");
				}
			

	}

		

	public boolean addUsers(List<EmployeeList> employeeList,int appID,String url,User user){
		//Set<EmployeeList> employees=new HashSet<EmployeeList>(employeeList);
		JDBCService service =new JDBCService();
		for(EmployeeList employee:employeeList){
			service.addSurvey(employee,String.valueOf(appID));
			new SendMailThread(employee.getEmail(), user.getEmail(), url, user,employee.getEmpName()).start();
		}
		new JDBCService().updateEmployeeCount(employeeList.size(),String.valueOf(appID));
		return false;
	}
	

		public ActionForward uploadManagerData(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			ApplicationModel uploadForm = (ApplicationModel) form;
			FileOutputStream outputStream = null;
			FormFile formFile = null;
			File newFile = null;
			String message=null;
			String fileName="";
			String returnValue="failureManager";
			
			try
			{
				formFile = uploadForm.getFormFile();
				fileName = formFile.getFileName();
				int ext = fileName.lastIndexOf('.')+1;
				String extNme = fileName.substring(ext);
				
				if (formFile.getFileSize() == 0)
					message="Please select a file to upload.";
				
				 else if (!(extNme.equals("xls") || extNme.equals("xlsx")))
						message="Please select only .xls/xlsx file to upload.";

				else
				{
					try
					{
						String path = getServlet().getServletContext().getRealPath("/")+"uploadManagerData";

						//Check for the specified folder "upload" in the path. If not exists create one.
						newFile = new File(path);
						if(!newFile.exists())
							newFile.mkdir();


						newFile = new File(path, fileName);
						FileOutputStream fos = new FileOutputStream(newFile);
						fos.write(formFile.getFileData());
						fos.flush();
						fos.close();
						
						List<EmployeeDetails> employeesDetails =new UploadManagerData().getManagersDetails(path,fileName);
						
						List<MgrPeerInfo> updatePeer =new UploadManagerData().readPeerData(path,fileName);
						if(updatePeer!=null && !updatePeer.isEmpty() && employeesDetails!=null && !employeesDetails.isEmpty()){
						DaoFactory.getUpdateManagerInfoDAO().updateManagerInfo(employeesDetails);
						DaoFactory.getUpdateManagerInfoDAO().updatePeerInfo(updatePeer);
						message="Managers data updated successfully...";
						returnValue="addApplication";
						}else{
							if(employeesDetails==null || employeesDetails.isEmpty()){
								message="Mgr-Shared Service sheet data/Mgr-Shared Service sheet header info invalide";
							} else if(updatePeer==null || updatePeer.isEmpty()){
							message="Peers data/sheet header info invalide";
							} 
						}
						
					}
					catch (Exception e)
					{
						message="Please contact admin.";
					}
				}
			}
			finally
			{
				if (outputStream != null)
					outputStream.close();
				if(null !=newFile && newFile.exists())
					newFile.delete();
			}
			request.setAttribute("message", message);
			return mapping.findForward(returnValue);
		}
		
		
		/*public ActionForward managerInfo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String managerName=request.getParameter("name");
			List<User> names=DaoFactory.getUpdateManagerInfoDAO().getManagerInfo(managerName);
				System.out.println(names);
			 	response.setContentType("text/text;charset=utf-8");
			    response.setHeader("cache-control", "no-cache");
			    PrintWriter out = response.getWriter();
			    if(names.size()!=1){
			    	 out.println("<div style='color:red;padding:4px 4px 4px;'> No record found Information</div>");
			    }else{
			    for(String name:names){
			    out.println("<div>"+name+"</div>");
			    }
			    }
			    out.flush();
			    return null;
		}*/
		public ActionForward updateManagerPeersInfo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.getSession().removeAttribute("recentApp");
			ArrayList<ApplicationModel> recentApp = new JDBCService()
					.viewRecentApplication(request.getParameter("startDate"),
							request.getParameter("endDate"));

			request.getSession().setAttribute("recentApp", recentApp);
			return mapping.findForward("viewRecent");
		}

		public ActionForward addImprovementOption(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			try{
				ApplicationModel model = (ApplicationModel) form;
				//System.out.println(model.getImprovementOptionName());
				//System.out.println(model.isImprovementActive());
				jdbcService.addImprovementOptions(model.getImprovementOptionName(),model.getImprovementOptionDescription(), model.isImprovementActive());
				request.setAttribute("SuccessFlag", "true");
				
			}catch (Exception e) {
				request.setAttribute("SuccessFlag", "flase");
				return mapping.findForward("ImprovementPage");
			}
			return mapping.findForward("ImprovementPage");
		}
		
}