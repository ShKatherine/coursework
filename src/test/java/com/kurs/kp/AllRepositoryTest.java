package com.kurs.kp;

import com.kurs.kp.model.Admin;
import com.kurs.kp.model.Code;
import com.kurs.kp.model.Comment;
import com.kurs.kp.model.Programmer;
import com.kurs.kp.model.Requires;
import com.kurs.kp.model.User;
import com.kurs.kp.repository.AdminRepository;
import com.kurs.kp.repository.CodeRepository;
import com.kurs.kp.repository.CommentRepository;
import com.kurs.kp.repository.MeetingRepository;
import com.kurs.kp.repository.ProgrammerRepository;
import com.kurs.kp.repository.RequiresRepository;
import com.kurs.kp.repository.UserRepository;
import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = Replace.NONE
)
@Rollback(false)
public class AllRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository AdminRepository;
    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private ProgrammerRepository programmerRepository;
    @Autowired
    private RequiresRepository requiresRepository;

    public AllRepositoryTest() {
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setIdU(82L);
        user.setEmailU("helen@gmail.com");
        user.setPasswordU("helenuser");
        Programmer programmer = new Programmer();
        programmer.setIdP(81L);
        programmer.setNameP("Елена");
        programmer.setSurnameP("Петрова");
        programmer.setPosition("Middle");
        user.setProgrammer(programmer);
        User savedUser = (User)this.userRepository.save(user);
        User existUser = (User)this.entityManager.find(User.class, savedUser.getIdU());
        Assertions.assertThat(user.getEmailU()).isEqualTo(existUser.getEmailU());
    }
    //напоимнание от меня из прошлого !! не забыть менять id!!
    @Test
    public void addCode() {
        Code code = new Code();
        //code.setIdCode(67);
        code.setLanguage("C++");
        code.setDocument("Test.cpp");
        Programmer programmer = this.programmerRepository.findByIdP(93L);
        Requires requires = new Requires();
        requires.setReq("TestC++.txt");
        //requires.setIdReq(66L);
        Code codes = this.codeRepository.findByDocument(code.getDocument());
        Programmer programmers = this.programmerRepository.findByIdP(programmer.getIdP());
        if (codes == null) {
            if (programmers != null) {
                new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String str = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\code", code.getDocument());
                File f = new File(str);
                String rstr = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\req", requires.getReq());
                File rf = new File(rstr);
                Requires requires1 = this.requiresRepository.findByReq(requires.getReq());
                if (requires1 == null) {
                    System.out.println(4);
                    if (f.exists()) {
                        if (rf.exists()) {
                            Requires savedRequires = (Requires)this.requiresRepository.save(requires);
                            code.setRequires(requires);
                            code.setProgrammer(programmer);
                            code.setDate(date);
                            Code savedCode = (Code)this.codeRepository.save(code);
                            Code existCode = (Code)this.entityManager.find(Code.class, savedCode.getIdCode());
                            Requires existReqiures = (Requires)this.entityManager.find(Requires.class, savedRequires.getIdReq());
                            Assertions.assertThat(requires.getIdReq()).isEqualTo(existReqiures.getIdReq());
                            Assertions.assertThat(code.getIdCode()).isEqualTo(existCode.getIdCode());
                        } else {
                            System.out.println("Проверьте наличие кода");
                        }
                    } else {
                        System.out.println("Проверьте наличие кода");
                    }
                } else {
                    System.out.println("Проверьте требования");
                }
            }
        } else {
            System.out.println("Уже имеется");
        }

    }

    @Test
    public void addCodes2() {
        Code code = new Code();
        code.setIdCode(69);
        code.setLanguage("С++");
        code.setDocument("Unity.cpp");
        Programmer programmer = this.programmerRepository.findByIdP(44L);
        Requires requires = new Requires();
        requires.setReq("UnityReq.txt");
        requires.setIdReq(66L);
        Code codes = this.codeRepository.findByDocument(code.getDocument());
        Programmer programmers = this.programmerRepository.findByIdP(programmer.getIdP());
        if (codes == null) {
            if (programmers != null) {
                new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String str = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\code", code.getDocument());
                File f = new File(str);
                String rstr = String.join("\\", "C:\\Users\\user\\kp2222\\kp\\req", requires.getReq());
                File rf = new File(rstr);
                Requires requires1 = this.requiresRepository.findByReq(requires.getReq());
                if (requires1 == null) {
                    System.out.println(4);
                    if (f.exists()) {
                        if (rf.exists()) {
                            Requires savedRequires = (Requires)this.requiresRepository.save(requires);
                            code.setRequires(requires);
                            code.setProgrammer(programmer);
                            code.setDate(date);
                            Code savedCode = (Code)this.codeRepository.save(code);
                            Code existCode = (Code)this.entityManager.find(Code.class, savedCode.getIdCode());
                            Requires existReqiures = (Requires)this.entityManager.find(Requires.class, savedRequires.getIdReq());
                            Assertions.assertThat(requires.getIdReq()).isEqualTo(existReqiures.getIdReq());
                            Assertions.assertThat(code.getIdCode()).isEqualTo(existCode.getIdCode());
                        } else {
                            System.out.println("Проверьте наличие кода");
                        }
                    } else {
                        System.out.println("Проверьте наличие кода");
                    }
                } else {
                    System.out.println("Проверьте требования");
                }
            }
        } else {
            System.out.println("Уже имеется");
        }

    }

    @Test
    public void testGetUser() {
        String email = "user@gmail";
        User users = this.userRepository.findByEmailU(email);
        Assertions.assertThat(users).isNotNull();
    }
// на несущствующего пользователя
    @Test
    public void testGetUser2() {
        String email = "ivan@gmail";
        User users = this.userRepository.findByEmailU(email);
        Assertions.assertThat(users).isNull();
    }

    @Test
    public void testGetAdmin() {
        String email = "kate@gmail";
        Admin admin = this.AdminRepository.findByEmailAdm(email);
        Assertions.assertThat(admin).isNotNull();
        System.out.println(admin.getEmail());
    }

    @Test
    public void testsUpdateU() {
        User user = new User();
        user.setIdU(101L);
        user.setEmailU("igor@gmail.com");
        user.setPasswordU("igoR2004");
        Programmer programmer = new Programmer();
        programmer.setIdP(100L);
        programmer.setNameP("Игорь");
        programmer.setSurnameP("Денисов");
        programmer.setPosition("Junior");
        user.setProgrammer(programmer);
        User userSave = (User)this.userRepository.save(user);
        User existUser = (User)this.entityManager.find(User.class, userSave.getIdU());
        Assertions.assertThat(user.getIdU()).isEqualTo(existUser.getIdU());
    }

    @Test
    public void testUpdate2U() {
        User user = new User();
        user.setIdU(101L);
        user.setEmailU("MARY@gmail.com");
        user.setPasswordU("MARY2");
        Programmer programmer = new Programmer();
        programmer.setIdP(100L);
        programmer.setNameP("Марина");
        programmer.setSurnameP("Денисова");
        programmer.setPosition("Junior");
        user.setProgrammer(programmer);
        User userSave = (User)this.userRepository.save(user);
        User existUser = (User)this.entityManager.find(User.class, userSave.getIdU());
        Assertions.assertThat(user.getIdU()).isEqualTo(existUser.getIdU());
    }

    @Test
    public void testsInput() {
        User user = new User();
        user.setIdU(45L);
        user.setEmailU("igor@gmail.com");
        user.setPasswordU("igoR2004");
        User users = this.userRepository.findByEmailU(user.getEmailU());
        if (users != null) {
            if (users.getPasswordU().equals(user.getPasswordU())) {
                System.out.println("Подключились");
            } else {
                System.out.println("Неверно введены данные");
            }
        } else {
            Admin admin = this.AdminRepository.findByEmailAdm(users.getEmailU());
            if (admin != null) {
                if (users.getPasswordU().equals(admin.getPassword())) {
                    System.out.println("Подключились");
                } else {
                    System.out.println("Неверно введены данные");
                }
            } else {
                System.out.println("Неверно введены данные");
            }
        }

    }

    @Test
    public void testsInput2() {
        User user = new User();
        user.setIdU(50L);
        user.setEmailU("test@gmail");
        user.setPasswordU("testrun");
        User users = this.userRepository.findByEmailU(user.getEmailU());
        if (users != null) {
            if (users.getPasswordU().equals(user.getPasswordU())) {
                System.out.println("Подключились");
            } else {
                System.out.println("Неверно введены данные");
            }
        } else {
            Admin admin = this.AdminRepository.findByEmailAdm(users.getEmailU());
            if (admin != null) {
                if (users.getPasswordU().equals(admin.getPassword())) {
                    System.out.println("Подключились");
                } else {
                    System.out.println("Неверно введены данные");
                }
            } else {
                System.out.println("Неверно введены данные");
            }
        }

    }
    @Test
    public void allPtest() {
        List<Programmer> programmerList = (List)this.programmerRepository.findAll();

        for(int i = 0; i < programmerList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Programmer)programmerList.get(i)).getNameP();
            var10000.println(var10001 + " " + ((Programmer)programmerList.get(i)).getSurnameP() + " " + ((Programmer)programmerList.get(i)).getPosition());
        }

    }

    @Test
    public void allUtest() {
        List<User> userList = (List) this.userRepository.findAll();

        for (int i = 0; i < userList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((User) userList.get(i)).getEmailU();
            var10000.println(var10001 +  " " + ((User) userList.get(i)).getPasswordU());
        }

    }
        @Test
    public void ReportingTest() {
        List<Code> codeList = (List)this.codeRepository.findAll();

        for(int i = 0; i < codeList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Code)codeList.get(i)).getDocument();
            var10000.println(var10001 + " " + ((Code)codeList.get(i)).getProgrammer().getSurnameP() + " " + ((Code)codeList.get(i)).getRequires().getReq() + " " + ((Code)codeList.get(i)).getLanguage());
        }

    }

    @Test
    public void sortTest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        Collections.sort(codeList, new Comparator<Code>() {
            public int compare(Code o1, Code o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        for(int i = 0; i < codeList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Code)codeList.get(i)).getDocument();
            var10000.println(var10001 + " " + ((Code)codeList.get(i)).getDate());
        }

    }

    @Test
    public void sortByDateTest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        Collections.sort(codeList, new Comparator<Code>() {
            public int compare(Code o1, Code o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        for(int i = 0; i < codeList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Code)codeList.get(i)).getDocument();
            var10000.println(var10001 + " " + ((Code)codeList.get(i)).getDate());
        }

    }

    @Test
    public void filterPyATest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        List<Code> outList = new ArrayList();

        int i;
        for(i = 0; i < codeList.size(); ++i) {
            if (((Code)codeList.get(i)).getLanguage().compareTo("Python") == 0) {
                outList.add((Code)codeList.get(i));
            }
        }

        if (outList.isEmpty()) {
            System.out.println("По данному параметру ничего не найдено");
        } else {
            for(i = 0; i < outList.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Code)outList.get(i)).getDocument();
                var10000.println(var10001 + " " + ((Code)outList.get(i)).getLanguage());
            }
        }

    }

    @Test
    public void filterJavaATest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        List<Code> outList = new ArrayList();

        int i;
        for(i = 0; i < codeList.size(); ++i) {
            if (((Code)codeList.get(i)).getLanguage().compareTo("Java") == 0) {
                outList.add((Code)codeList.get(i));
            }
        }

        if (outList.isEmpty()) {
            System.out.println("По данному параметру ничего не найдено");
        } else {
            for(i = 0; i < outList.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Code)outList.get(i)).getDocument();
                var10000.println(var10001 + " " + ((Code)outList.get(i)).getLanguage());
            }
        }

    }

    @Test
    public void filterCATest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        List<Code> outList = new ArrayList();

        int i;
        for(i = 0; i < codeList.size(); ++i) {
            if (((Code)codeList.get(i)).getLanguage().compareTo("C++") == 0) {
                outList.add((Code)codeList.get(i));
            }
        }

        if (outList.isEmpty()) {
            System.out.println("По данному параметру ничего не найдено");
        } else {
            for(i = 0; i < outList.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Code)outList.get(i)).getDocument();
                var10000.println(var10001 + " " + ((Code)outList.get(i)).getLanguage());
            }
        }

    }

    //проверка на null если нет такого кода
    @Test
    public void filterCNullTest() {
        List<Code> codeList = (List)this.codeRepository.findAll();
        List<Code> outList = new ArrayList();

        int i;
        for(i = 0; i < codeList.size(); ++i) {
            if (((Code)codeList.get(i)).getLanguage().compareTo("Go") == 0) {
                outList.add((Code)codeList.get(i));
            }
        }

        if (outList.isEmpty()) {
            System.out.println("По данному параметру ничего не найдено");
        } else {
            for(i = 0; i < outList.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Code)outList.get(i)).getDocument();
                var10000.println(var10001 + " " + ((Code)outList.get(i)).getLanguage());
            }
        }

    }


    @Test
    public void SeeCommentTest() {
        List<Comment> commentList = (List)this.commentRepository.findAll();

        for(int i = 0; i < commentList.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Comment)commentList.get(i)).getTyp();
            var10000.println(var10001 + " " + ((Comment)commentList.get(i)).getCom() + " " + ((Comment)commentList.get(i)).getCode().getDocument());
        }

    }

    @Test
    public void DeleteUserTest() {
        Long id = 45L;
        this.userRepository.deleteById(id);
    }

    @Test
    public void DeleteUsTest2() {
        this.userRepository.deleteById(69L);
    }


    @Test
    public void testGetP() {
        Long id = 20L;
        Programmer programmer = this.programmerRepository.findByIdP(id);
        Assertions.assertThat(programmer).isNotNull();
        System.out.println(programmer.getNameP());
        //Светлана - ожидаемое значение
    }

    //Проверка что нет таких id
    @Test
    public void testGetP2() {
        Long id = 2L;
        Programmer programmer = this.programmerRepository.findByIdP(id);
        Assertions.assertThat(programmer).isNull();
    }
}
