package ml.wonwoo.springparametertype.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class WebController {

    @GetMapping("/hi")
    public String redirectAttributes(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", 1);
        redirectAttributes.addAttribute("foo", "bar");
        return "redirect:redirectAttributes/{id}";
    }

    @GetMapping("/redirectAttributes/{id}")
    @ResponseBody
    public String redirectAttributesHi(@PathVariable Long id, String foo) {
        return foo;
    }

    @ModelAttribute
    public void foo(HttpServletRequest request) {
        request.setAttribute("foo", "bar");
    }

    @GetMapping("/requestAttribute")
    @ResponseBody
    public String requestAttribute(@RequestAttribute String foo) {
        return foo;
    }

    @GetMapping("/value")
    @ResponseBody
    public String value(@Value("${name}") String name) {
        return name;
    }


    @GetMapping("/uriComponentsBuilder")
    @ResponseBody
    public String uri(UriComponentsBuilder uriComponentsBuilder) {
        return "";
    }

    @GetMapping("/matrix/{id}")
    @ResponseBody
    public String matrix(@PathVariable String id, @MatrixVariable int q) {
        return id;
    }
}
