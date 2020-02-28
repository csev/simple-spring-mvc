package org.learnxp;

/* This does not use the request filter because it needs full control of response headers.
       But this also means that no work that should be in a session should be done in this servlet.
       In particular, never use ThreadLocal in this servlet.
 */

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyServlet  {

	private static final long serialVersionUID = 1L;

    @RequestMapping("/")
	@ResponseBody
    public String helloWorld()
    {
		System.out.println("In helloWorld()");
		return "hello world";
    }
}
