package com.example.webnew;

public class DeleteElements {
   // static InMemoryStorage st = InMemoryStorage.getInstance();
    static PostgresSQLStorage st = PostgresSQLStorage.getInstance();
    public static boolean deleteElement(long id){
        if (st.deleteElements(id)){
            System.out.println(id);
            return true;
        }else
            System.out.println("it is not exist");
        return false;
    }

}
