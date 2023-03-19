package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> emailToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        emailToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
        emailToProfile.put(userProfile.getEmail(), userProfile);
    }
    public void deleteUser(UserProfile userProfile) {
        loginToProfile.remove(userProfile.getLogin(), userProfile);
        emailToProfile.remove(userProfile.getEmail(), userProfile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public UserProfile getUserByEmail(String email) {
        return emailToProfile.get(email);
    }
}
