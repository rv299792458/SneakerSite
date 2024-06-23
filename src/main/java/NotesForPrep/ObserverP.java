package NotesForPrep;

import java.util.ArrayList;
import java.util.List;


    interface  Observer{
        void update(String sub);
    }
    interface  Subject{

        void addObserver(Observer obj);
        void deleteObserver(Observer obj);
        void setOrUpdateSubject(String sub);
    }

    class PhoneDisplay implements Observer{
        public void update(String sub){
            System.out.println("Sub for Observer PhoneDisplay is: "+ sub);
        }
    }
    class TVDisplay implements Observer{

        public void update(String sub){
            System.out.println("Sub for Observer PhoneDisplay is: "+ sub);
        }
    }

    class WeatherStation implements Subject{
        private List<Observer> observers = new ArrayList<>();
        private String subject;

        @Override
        public void addObserver(Observer obj) {
            observers.add(obj);
        }

        @Override
        public void deleteObserver(Observer obj) {
            observers.remove(obj);
        }

        @Override
        public void setOrUpdateSubject(String sub) {
            subject=sub;
            for(Observer o : observers)
                o.update(subject);
        }
    }


class ObserverP{
    public static void main(String[] args) {
        Observer tv = new TVDisplay();
        Observer phone = new PhoneDisplay();

        Subject ws = new WeatherStation();
        ws.addObserver(tv);
        ws.addObserver(phone);
        ws.setOrUpdateSubject("sunny");
        ws.setOrUpdateSubject("Rainy");
        ws.setOrUpdateSubject("ThunderStorm");
    }
}



