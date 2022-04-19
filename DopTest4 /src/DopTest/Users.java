package DopTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Users {
        private User[] users;
        private int currentUserNumber;

//  public void us (){
        // todo auto password change for users, registered more than DAYS days ago
//        int users = 3;
//        for (int i = 0; i < users; i++) {
//           if(User[i].getRegistrationDate() != Date && User[i].getRegistrationDate() == Date){
//              //в таом случае меняю пароли;
//               //не успел доделать;
//           }
//        }
//    }
        public Users(final int usersNumber) {
            this.users = new User[usersNumber];
            currentUserNumber = -1;
        }

        public User findOldestUser() {
            User user1 = users[0];

            for (final User user : users) {
                if (user.getRegistrationDate().isBefore(user1.getRegistrationDate())) user1 = user;
            }

            return user1;
        }

        public void addUser(final User user) {
            if (++currentUserNumber < users.length) {
                users[currentUserNumber] = user;
            }
        }

        private void delUserByNumber(final int number) {
            final Users tempUsers = new Users(currentUserNumber);
            tempUsers.currentUserNumber = currentUserNumber;

            int newIndex = 0;
            for (int i = 0; i <= currentUserNumber; i++) {
                if (i == number) continue;
                tempUsers.users[newIndex++] = users[i];
            }
            users = tempUsers.users;
            currentUserNumber--;
        }

        public void removeUser(final int number) {
            if (number < 0 || number >= currentUserNumber) {
                return;
            } else {
                delUserByNumber(number);
            }
        }

        public void removeUser(final String login) {
            int number = 0;
            for (final User user : users) {
                if (user.getLogin().equalsIgnoreCase(login.strip())) {
                    delUserByNumber(number);

                    return;
                }
                number++;
            }
        }

        @Override
        public String toString() {
            String result = "Users: " + System.lineSeparator();

            for (final User user : users) {
                result += user + System.lineSeparator();
            }

            return result;
        }
    }
