package com.example.webnew;
import java.util.ArrayList;
import java.util.List;
public class InMemoryStorage implements Storage{
    private static final InMemoryStorage instance = new InMemoryStorage();
    private List<PrintedProduct> listField;
    public static InMemoryStorage getInstance(){
        return instance;
    }
    private InMemoryStorage(){
        listField=new ArrayList<PrintedProduct>();
    }

    @Override
    public boolean addElements(PrintedProduct element) {
        this.listField.add(element);
        return true;
    }
@Override
     public List<PrintedProduct> showAllEl(){
        return listField;
     }
@Override
     public PrintedProduct findElements(long id){
         for (PrintedProduct el:listField) {
             if (el.getNumID()==id)
             return el;
             System.out.println(el);

         }
         return null;
     }
     @Override
     public boolean deleteElements(long id){
        PrintedProduct elem=findElements(id);
         if (elem==null)
             return false;
         else {
             listField.remove(elem);
             return true;
         }
     }

    @Override
     public void updateElements( PrintedProduct newElem){
         this.deleteElements(newElem.getNumID());
         this.addElements(newElem);

     }

}
