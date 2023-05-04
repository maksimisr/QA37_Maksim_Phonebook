package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.name;

public class DataProviderContact {
    public class DataProviderUser {
        @DataProvider
        public Iterator<Object[]> loginData() {
            Random i = new Random();
            List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{Contact.builder().name("Maksim").lastName("Galileo").
                    phone("123884" + i + "128835").
                    email("galileo199" + i + "@gmail.com").
                    address("NY").
                    description("SuccessAllFields")
                    .build()});

            return list.iterator();
        }
    }
@DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //read from file
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.cvs.csv")));
        String line=  reader.readLine();
        while (line!=null){
            String[] all= line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line=reader.readLine();
        }


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>contactCVS() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line= reader.readLine();
        while (line!=null){
            String[] all= line.split(",");
            list.add(new Object[]{Contact.builder().name(all[0]).lastName(all[1]).email(all[2]).phone(all[3]).address(all[4]).description(all[5])
                    .build()});
            line=reader.readLine();
        }

        return list.iterator();
    }
}
