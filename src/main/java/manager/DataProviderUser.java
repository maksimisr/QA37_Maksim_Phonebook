package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list= new ArrayList<>();
        list.add( new Object[]{new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$")});
      //  list.add( new Object[]{new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$")});
        return  list.iterator();
    }



}
