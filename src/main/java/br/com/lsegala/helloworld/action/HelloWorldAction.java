package br.com.lsegala.helloworld.action;

import br.com.lsegala.helloworld.form.HelloWorldForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class HelloWorldAction extends Action {
    Logger log = Logger.getLogger(HelloWorldAction.class.getName());

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HelloWorldForm helloWorldForm = (HelloWorldForm) form;
        log.info("Entering in execute with param: "+helloWorldForm.getName());
        return mapping.findForward("success");
    }
}
