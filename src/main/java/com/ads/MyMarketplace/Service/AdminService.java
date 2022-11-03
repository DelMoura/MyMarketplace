package com.ads.MyMarketplace.Service;

import com.ads.MyMarketplace.Model.Admin;
import com.ads.MyMarketplace.Model.Product;
import com.ads.MyMarketplace.Repository.AdminRepository;
import com.ads.MyMarketplace.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class AdminService {


    private AdminRepository repositoryAdmin;
    private KeyAdminService key;

    public void registerAdmin(Admin admin) {
        repositoryAdmin.save(admin);
    }

    public String loginAdmin(Admin admin) {
        var admins = this.repositoryAdmin.findByUsername(admin.getUsername());
        if (admins.getPassword().equals(admin.getPassword())) {
            key.setKEY(keyLogin(new Random()));
            return key.getKEY();

        }

        return null;

    }

    public String keyLogin(Random random) {

        String text = "";
        for (int i = 0; i < 10; i++) {
            text = text + random.nextInt();
        }
        return text;
    }


}
