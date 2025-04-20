package com.example.music_streaming_service.service;


import com.example.music_streaming_service.dao.IAdminRepository;
import com.example.music_streaming_service.model.Admin;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {

    @Autowired
    IAdminRepository adminRepository;
    public void saveAdmin(Admin requestAdmin) {
        adminRepository.save(requestAdmin);
    }

    public JSONObject getadmin(String adminName) {
       Admin admin=adminRepository.findByAdminName(adminName);
       JSONObject jsonObject=new JSONObject();
       if(admin!=null){
           jsonObject.put("admindetails",admin);
       }
       else{
          jsonObject.put("admin","admin does not exists");
       }
       return jsonObject;
    }

    public String savelogin(Admin admin) {

       Admin newadmin= adminRepository.findByAdminName(admin.getAdminName());
       if(newadmin.getPassword().equals(admin.getPassword())){
           return "login succcesfull";
       }
       return "password is wrong";
    }
}
