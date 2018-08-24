package test.bcrypt;

import org.mindrot.jbcrypt.BCrypt;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Bcrypt bunndle started");
        String test_passwd = "abcdefghijklmnopqrstuvwxyz";
        String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";
        String computedHash = hashPassword(test_passwd);
        System.out.println(computedHash);
        boolean isPasswordVeriefied = checkPassword(test_passwd, computedHash);
        System.out.println("is password verified:" + isPasswordVeriefied);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }

    private static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }
}