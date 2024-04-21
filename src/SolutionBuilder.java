import task1.User;
import taskStar.UserStar;

import java.util.ArrayList;

public class SolutionBuilder {
    public static void buildTask1() {
        System.out.println("\n\n                    Задача 1\n");
        User user1 = new User("Name", "name@example.com");
        User user2 = new User("Name", "name@example.com");

        // Сравнение с помощью метода equals()
        System.out.println(user1.equals(user2));
    }
//    Создать класс для описания пользователя системы. Переопределить в классе методы
//    toString,hashcode и equals. Создать несколько экземпляров класса с одним и тем же
//    значением полей и сравнить с помощью метода equals.

    public static int getIdForCloning(ArrayList<UserStar> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                return i;
            }
        }

        return -1;
    }

    public static void buildTaskStar() {
        System.out.println("\n\n                    Задача *\n");
        ArrayList<UserStar> userList = new ArrayList<>();
        userList.add(new UserStar("123", new User("Monkey", "monkey@example.com")));
        userList.add(new UserStar("777", new User("Gleb", "gleb@example.com")));
        userList.add(new UserStar("999", new User("Черненький", "black@example.com")));
        userList.add(new UserStar("465", new User("Беленький", "white@example.com")));


        String cloneMethod = "deepClone";   //"deepClone" / "clone" - Вообще говоря вводим
        String cloneId = "999";         //Тоже вводим

        boolean checkCloneMethod = true;
        int id = getIdForCloning(userList, cloneId);

        if (id != -1) {
            UserStar clone = null;
            if (cloneMethod.equals("clone")) {
                System.out.println("Поверхностное клонирование");
                clone = userList.get(id).clone();
            } else if (cloneMethod.equals("deepClone")) {
                System.out.println("Глубокое клонирование");
                clone = userList.get(id).deepClone();

            } else {
                System.out.println("Не распознан тип клонирования...");
            }

            if(checkCloneMethod && clone != null){
                System.out.println("Меняем клонируемый оюъект:");
                clone.setUserEmail("???");
                clone.setId("000");

                System.out.println("Получаем:");
                System.out.println(clone.toString());
                System.out.println(userList.get(id).toString());
            }

        } else {
            System.out.println("Нет объекта для клонирования...");
        }
    }
//    Создать программу для реализации поверхностного и глубокого клонирования объекта
//    класса User. Пусть на вход программе будет передаваться тип операции клонирования
//    (поверхностное клонирование или глубокое), а также id юзера для клонирования.

}
