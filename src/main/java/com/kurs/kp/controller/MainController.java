package com.kurs.kp.controller;

import org.springframework.validation.BindingResult;
import com.kurs.kp.model.*;
import com.kurs.kp.repository.*;
import com.kurs.kp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.nio.file.Path;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RequiresRepository requiresRepository;
    private User UserDetails;
    private Code CodeDetails;
    private Programmer ProgrammerDetails;

    Admin admin = Admin.getInstance();
    @GetMapping("")
    public String Home(Model model)
    {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/singUp")
    public String singUp(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("programmer", new Programmer());
        return "SignUp";
    }



    @PostMapping("/processRegister")
    public String processRegister(@ModelAttribute("user") User users, @ModelAttribute("programmer") Programmer programmer, Model model)
    {
        User user = userRepository.findByEmailU(users.getEmailU());
        System.out.println(user);
        if (user == null)
        {
            admin = adminRepository.findByEmailAdm(users.getEmailU());
            System.out.println(admin);
            if(admin == null) {
                programmerRepository.save(programmer);
                users.setProgrammer(programmer);
                userRepository.save(users);
            } else
            {
                model.addAttribute("message", "Возможно вы уже зарегестрированны");
                return "SignUp";
            }
        } else
        {
            model.addAttribute("message", "Возможно вы уже зарегестрированны");
            return "SignUp";
        }
        return "index";
    }

    @PostMapping("/input")
    public String input(@ModelAttribute("user") User users, BindingResult bindingResult, Model model)
    {
        User user = userRepository.findByEmailU(users.getEmailU());
        if (user != null) {
            if (users.getPasswordU().equals(user.getPasswordU()))
            {
                System.out.println("Подключились");
                UserDetails = new User();
                UserDetails.setIdU(user.getIdU());
                UserDetails.setEmailU(user.getEmailU());
                UserDetails.setPasswordU(user.getPasswordU());
                UserDetails.setProgrammer(user.getProgrammer());
                ProgrammerDetails = new Programmer();
                ProgrammerDetails.setIdP(user.getProgrammer().getIdP());
                ProgrammerDetails.setPosition(user.getProgrammer().getPosition());
                ProgrammerDetails.setNameP(user.getProgrammer().getNameP());
                ProgrammerDetails.setSurnameP(user.getProgrammer().getSurnameP());
                return "UsersMenu";
            } else {
                System.out.println("Неверно введены данные");
            }
        }
        else{
            admin = adminRepository.findByEmailAdm(users.getEmailU());
            if (admin != null) {
                if (users.getPasswordU().equals(admin.getPassword()))
                {
                    System.out.println("Подключились");
                    return "AdminMenu";
                } else {
                    System.out.println("Неверно введены данные");
                }
            } else {
                System.out.println("Неверно введены данные");
            }

        }
        return "index";
    }


     @GetMapping("/filterExit")
     public String filterExit(Model model)
     {
         model.addAttribute("code", new Code());
         return "UsersMenu";
     }


    @GetMapping("/comExit")
    public String comExit(Model model)
    {
        model.addAttribute("comment", new Comment());
        return "UsersMenu";
    }

    @GetMapping("/filterExitA")
    public String filterExitA(Model model)
    {
        model.addAttribute("code", new Code());
        return "AdminMenu";
    }

    @GetMapping("/sortExit")
    public String sortExit(Model model)
    {
        model.addAttribute("code", new Code());
        return "AdminMenu";
    }                                                      
    @GetMapping("/sortExitU")
    public String sortExitU(Model model)
    {
        model.addAttribute("code", new Code());
        return "UsersMenu";
    }
     @GetMapping("/repExit")
     public String repExit(Model model)
     {
         model.addAttribute("code", new Code());
         return "AdminMenu";
     }
    @GetMapping("/allPExit")
    public String allPExit(Model model)
    {
        model.addAttribute("programmer", new Programmer());
        return "ManageUsers";
    }                                                           


    @GetMapping("/exit")
    public String Exit(Model model)
    {
        model.addAttribute("user", new User());
        return "index";
    }
    @GetMapping("/exit2")
    public String Exit2(Model model)
    {
        model.addAttribute("user", new User());
        return "AdminMenu";
    }

    @GetMapping("/manage")
    public String Manage(Model model)
    {
        model.addAttribute("user", new User());
        return "ManageUsers";
    }
    @GetMapping("/down")
    public String Down(Model model)
    {
        model.addAttribute("code", new Code());
        model.addAttribute("requires", new Requires());
        return "DownloadCode";
    }

    @GetMapping("/meet")
    public String Meet(Model model)
    {
        model.addAttribute("meeting", new Meeting());
        return "Meet";
    }


     @GetMapping("/allMeet")
       public String AllMeet(Model model)
       {
           List<Meeting> meetingList = (List<Meeting>) meetingRepository.findAll();
           model.addAttribute("meetingList",  meetingList);

           return "AllMeet";
       }
       
    @GetMapping("/addU")
    public String AddU(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("programmer", new Programmer());
        return "AddUser";
    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User users, @ModelAttribute("programmer") Programmer programmer, Model model)
    {
        User user = userRepository.findByEmailU(users.getEmailU());
        System.out.println(user);
        if (user == null)
        {
            admin = adminRepository.findByEmailAdm(users.getEmailU());
            System.out.println(admin);
            if(admin == null) {
                programmerRepository.save(programmer);
                users.setProgrammer(programmer);
                userRepository.save(users);
            } else
            {
                model.addAttribute("message", "Возможно вы уже зарегестрированны");
                return "AddUser";
            }
        } else
        {
            model.addAttribute("message", "Возможно вы уже зарегестрированны");
            return "AddUser";
        }
        return "ManageUsers";
    }


    @PostMapping("/addCode")
    public String addCode(@ModelAttribute("code") Code code, @ModelAttribute("requires") Requires requires, Model model)
    {  System.out.println(0);
        Code codes = codeRepository.findByDocument(code.getDocument());
        System.out.println(1);
        if (codes == null) {
            Programmer programmer = programmerRepository.findByIdP(UserDetails.getProgrammer().getIdP());
            System.out.println(2);
            if (programmer == null) {

                model.addAttribute("message", "Ошибка");
                return "UsersMenu";

            } else {
                System.out.println(3);
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String str = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\code", code.getDocument());
                File f = new File(str);
                String rstr = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\req", requires.getReq());
               File rf = new File(rstr);
                Requires requires1 = requiresRepository.findByReq(requires.getReq());
                if (requires1 == null) {
                    System.out.println(4);
                    if (f.exists()) {
                        if (rf.exists()) {

                            requiresRepository.save(requires);
                            code.setRequires(requires);
                            code.setProgrammer(programmer);
                            code.setDate(date);
                            codeRepository.save(code);
                        } else {
                            model.addAttribute("message", "Проверьте наличие кода");
                            return "DownloadCode";
                        }
                    } else {
                        model.addAttribute("message", "Проверьте наличие кода");
                        return "DownloadCode";
                    }
                } else {
                    model.addAttribute("message", "Проверьте требования");
                    return "DownloadCode";
                }
            }


        } else
        {
            model.addAttribute("message", "Уже имеется");
            return "DownloadCode";
        }
        return "UsersMenu";
    }

    @GetMapping("/TableForReview")
    public String TableForReview(Model model)
    {
        List<Code> codeList = (List<Code>) codeRepository.findAll();
        model.addAttribute("codeList", codeList);
        return "TableForReview";
    }




    @GetMapping("/EditDeleteUser")
    public String EditDeleteUser(Model model)
    {
        List<User> userList = (List<User>) userRepository.findAll();
        model.addAttribute("userList", userList);
        return "EditDeleteUser";
    }

    @GetMapping("/AllProgrammers")
    public String AllProgrammers(Model model)
    {
        List<Programmer> programmerList = (List<Programmer>) programmerRepository.findAll();
        model.addAttribute("programmerList", programmerList);
        return "AllProgrammers";
    }

    @GetMapping ("/Reporting")
    public String Reporting(Model model)
    {
        List<Code> codeList = (List<Code>) codeRepository.findAll();
        model.addAttribute("codeList", codeList);
        return "Reporting";
    }

    @GetMapping("/sort")
        public String sort(Model model)
        {
            List<Code> codeList = (List<Code>) codeRepository.findAll();
            model.addAttribute("codeList", codeList);
            return "sort";
        }
    @GetMapping("/sortByDate")

        public String sortByDate(Model model)
        {
            List<Code> codeList =  (List<Code>)codeRepository.findAll();
            Collections.sort(codeList , new Comparator<Code>()
            {
                //@Override
                public int compare(Code o1, Code o2) {
                    return o2.getDate().compareTo(o1.getDate());
                }
            });
         model.addAttribute("codeList", codeList);
         return "sort";
        }
      @GetMapping("/sortByDate2")

          public String sortByDate2(Model model)
          {
              List<Code> codeList =  (List<Code>)codeRepository.findAll();
              Collections.sort(codeList , new Comparator<Code>()
              {
                  @Override
                  public int compare(Code o1, Code o2) {
                      return o1.getDate().compareTo(o2.getDate());
                  }
              });
           model.addAttribute("codeList", codeList);
           return "sort";
          }

     @GetMapping("/sortU")
         public String sortU(Model model)
         {
             List<Code> codeList = (List<Code>) codeRepository.findAll();
             model.addAttribute("codeList", codeList);
             return "sortU";
         }
     @GetMapping("/sortByDateU")

         public String sortByDateU(Model model)
         {
             List<Code> codeList =  (List<Code>)codeRepository.findAll();
             Collections.sort(codeList , new Comparator<Code>()
             {
                 //@Override
                 public int compare(Code o1, Code o2) {
                     return o2.getDate().compareTo(o1.getDate());
                 }
             });
          model.addAttribute("codeList", codeList);
          return "sortU";
         }
       @GetMapping("/sortByDate2U")

           public String sortByDate2U(Model model)
           {
               List<Code> codeList =  (List<Code>)codeRepository.findAll();
               Collections.sort(codeList , new Comparator<Code>()
               {
                   @Override
                   public int compare(Code o1, Code o2) {
                       return o1.getDate().compareTo(o2.getDate());
                   }
               });
            model.addAttribute("codeList", codeList);
            return "sortU";
           }
           
    @GetMapping("/filterA")
         public String filterA(Model model)
         {
             List<Code> codeList = (List<Code>) codeRepository.findAll();
             model.addAttribute("codeList", codeList);
             return "filterA";
         }

    @GetMapping("/filter")
        public String filter(Model model)
        {
            List<Code> codeList = (List<Code>) codeRepository.findAll();
            model.addAttribute("codeList", codeList);
            return "filter";
        }

    @GetMapping("/Com")
        public String Com(@ModelAttribute ("code") Code code, Model model)
        {
            model.addAttribute("comment", new Comment());
            model.addAttribute("code", new Code());
            System.out.println(code.getIdCode());
            return "Com";
        }

    @GetMapping("/filterPyA")
         public String filterPyA(Model model)
         {
             List<Code> codeList = (List<Code>) codeRepository.findAll();
             List<Code> outList = new ArrayList<>();
             for (int i=0; i < codeList.size(); i++) {
                 if (codeList.get(i).getLanguage().compareTo("Python") == 0) {
                     outList.add(codeList.get(i));
                 }
             }
             if (outList.isEmpty()) {
                 model.addAttribute("message", "По данному параметру ничего не найдено");
             } else {
                 model.addAttribute("codeList", outList);
             }
             return "filterA";
         }
    @GetMapping("/filterJavaA")
         public String filterJavaA(Model model)
         {
             List<Code> codeList = (List<Code>) codeRepository.findAll();
             List<Code> outList = new ArrayList<>();
             for (int i=0; i < codeList.size(); i++) {
                 if (codeList.get(i).getLanguage().compareTo("Java") == 0) {
                     outList.add(codeList.get(i));
                 }
             }
             if (outList.isEmpty()) {
                 model.addAttribute("message", "По данному параметру ничего не найдено");
             } else {
                 model.addAttribute("codeList", outList);
             }
             return "filterA";
         }

     @GetMapping("/filterCA")
          public String filterCA(Model model)
          {
              List<Code> codeList = (List<Code>) codeRepository.findAll();
              List<Code> outList = new ArrayList<>();
              for (int i=0; i < codeList.size(); i++) {
                  if (codeList.get(i).getLanguage().compareTo("C++") == 0) {
                      outList.add(codeList.get(i));
                  }
              }
              if (outList.isEmpty()) {
                  model.addAttribute("message", "По данному параметру ничего не найдено");
              } else {
                  model.addAttribute("codeList", outList);
              }
              return "filterA";
          }

   @GetMapping("/filterPy")
        public String filterPy(Model model)
        {
            List<Code> codeList = (List<Code>) codeRepository.findAll();
            List<Code> outList = new ArrayList<>();
            for (int i=0; i < codeList.size(); i++) {
                if (codeList.get(i).getLanguage().compareTo("Python") == 0) {
                    outList.add(codeList.get(i));
                }
            }
            if (outList.isEmpty()) {
                model.addAttribute("message", "По данному параметру ничего не найдено");
            } else {
                model.addAttribute("codeList", outList);
            }
            return "filter";
        }
   @GetMapping("/filterJava")
        public String filterJava(Model model)
        {
            List<Code> codeList = (List<Code>) codeRepository.findAll();
            List<Code> outList = new ArrayList<>();
            for (int i=0; i < codeList.size(); i++) {
                if (codeList.get(i).getLanguage().compareTo("Java") == 0) {
                    outList.add(codeList.get(i));
                }
            }
            if (outList.isEmpty()) {
                model.addAttribute("message", "По данному параметру ничего не найдено");
            } else {
                model.addAttribute("codeList", outList);
            }
            return "filter";
        }

    @GetMapping("/filterC")
         public String filterC(Model model)
         {
             List<Code> codeList = (List<Code>) codeRepository.findAll();
             List<Code> outList = new ArrayList<>();
             for (int i=0; i < codeList.size(); i++) {
                 if (codeList.get(i).getLanguage().compareTo("C++") == 0) {
                     outList.add(codeList.get(i));
                 }
             }
             if (outList.isEmpty()) {
                 model.addAttribute("message", "По данному параметру ничего не найдено");
             } else {
                 model.addAttribute("codeList", outList);
             }
             return "filter";
         }

    @GetMapping("/DeleteUs/{id}")
    private String DeleteUs(@PathVariable("id") Long id)
    {
        System.out.println(id);
        usersService.delete(id);
        return "redirect:/EditDeleteUser";
    }

    @GetMapping("/EditUser/{id}")
    private ModelAndView EditUser(@PathVariable("id") Long id)
    {
        System.out.println(111111);
        ModelAndView mav = new ModelAndView("EditUser");
        System.out.println(222222);
        User user = userRepository.findById(id).get();
        System.out.println(333333);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/saveUser")
    private String saveUser(@ModelAttribute("user") User users,Model model)
    {

        User user = userRepository.findById(users.getIdU()).get();
        userRepository.save(users);
        return "redirect:/EditDeleteUser";
    }


    @GetMapping("/SeeComment")
    public String SeeComment(Model model)
    {
        List<Code>  codeList = (List<Code>) codeRepository.findAll();
        List<Comment> commentList = (List<Comment>) commentRepository.findAll(); 
        model.addAttribute("commentList", commentList);
        return "SeeComment";
    }
    @GetMapping("/Review/{id}")
    private ModelAndView Review(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("comment", new Comment()); 
        System.out.println(111111);
        ModelAndView mav = new ModelAndView("Review");
        System.out.println(222222);
        Code code= codeRepository.findByIdCode(id);
        Requires requires= requiresRepository.findByReq(code.getRequires().getReq());
        System.out.println(333333);
        String str = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\code", code.getDocument());
        File codefile = new File(str);
        System.out.println(444444444);
        String str1 = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\req",code.getRequires().getReq());
        String result1 = readFromFile(str1);
        String result = readFromFile(str);
        System.out.println(55555);
        System.out.println(result);
        code.setDocument(result);
        requires.setReq(result1);
        code.setRequires(requires);
        CodeDetails = new Code();
        CodeDetails.setIdCode(code.getIdCode());
        CodeDetails.setDocument(code.getDocument());
        CodeDetails.setLanguage(code.getLanguage());
        CodeDetails.setDate(code.getDate());
        mav.addObject("code", code);

        return mav;
    }
    private String readFromFile(String nameFile) {
        try (FileReader reader = new FileReader(nameFile)) {
            Scanner scan = new Scanner(reader);
            StringBuilder stringBuilder = new StringBuilder();

            //ArrayList<String> str = new ArrayList<String>();
            while (scan.hasNextLine()) {
                stringBuilder.append(scan.nextLine());
                stringBuilder.append("\n");
                //str.add(scan.nextLine());
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    @PostMapping("/saveComment")
    private String saveComment(@ModelAttribute("comment") Comment comment,Model model) {
         System.out.println(666666);
        System.out.println(444);
        comment.setCode(CodeDetails);
        System.out.println(8888);
        commentRepository.save(comment);
        System.out.println(comment.getCom());
        System.out.println(comment.getTyp());
        return "redirect:/TableForReview";
    }
   @PostMapping("/saveMes")
   private String saveMes(@ModelAttribute("meeting") Meeting mess,Model model) {

       model.addAttribute("user", new User());
       meetingRepository.save(mess);
       return "UsersMenu";
   }

    @PostMapping("/searchID")
    public String searchID(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

       User user1 = userRepository.findByEmailU(user.getEmailU());

        model.addAttribute("user", user1);
        return "Search";
    }

        @GetMapping("/search")
        public String search(Model model)
        {
                List<User> userList = (List<User>) userRepository.findAll();
                model.addAttribute("userList", userList);
                return "Search";

        }


}

