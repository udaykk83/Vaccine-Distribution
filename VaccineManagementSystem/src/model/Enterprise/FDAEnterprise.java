/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enterprise;

import java.util.ArrayList;
import model.Role.Role;

/**
 *
 * @author pawan
 */
public class FDAEnterprise extends Enterprise{
    public FDAEnterprise(String name){
        super(name,Enterprise.EnterpriseType.FDA);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
