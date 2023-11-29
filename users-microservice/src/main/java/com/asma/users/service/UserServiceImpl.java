package com.asma.users.service;
import java.util.List;
import java.util.Random;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asma.users.entities.Role;
import com.asma.users.entities.User;

import com.asma.users.repos.RoleRepository;
import com.asma.users.repos.userRepository;

import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	
    @Autowired
    userRepository userRep;
    @Autowired
    RoleRepository roleRep;
	
	 @Value("${spring.mail.username}")
	    private String from;
	
	 @Autowired
		BCryptPasswordEncoder bCryptPasswordEncoder;
		@Autowired
		private JavaMailSender javaMailSender;
   /* @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }*/
	

		@Value("${spring.mail.username}")
		private String mailAddress;
		@Override
		public User saveUser(User user) {
			Random random = new Random();
			String verificationCode = String.format("%04d", random.nextInt(10000));
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setSubject("Activation ");
			
			simpleMailMessage.setTo("raiesasma8@gmail.com");
			simpleMailMessage.setFrom(mailAddress);
			String url="http://localhost:8081/users/activateUser/"+user.getUsername()+"/"+verificationCode;
			simpleMailMessage.setText(url);
			
			javaMailSender.send(simpleMailMessage);

			user.setVerificationCode(verificationCode);
			List<Role>roles=new ArrayList<>();
			Role r=roleRep.findByRole("USER");
			roles.add(r);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRoles(roles);
			System.out.println(user.getVerificationCode());
			return userRep.save(user);
		}
		@Override
		public User activateUser(String username , String code)
		{
			User user=userRep.findByUsername(username);
			if(user!=null)
			{
				if(user.getEnabled()==null || user.getEnabled()==false)
				{
					if(user.getVerificationCode().equals(code)==true)
					{
						user.setEnabled(true);
					
						userRep.save(user);
						return user;
					}
					else
					{
						System.out.println(user.getVerificationCode());
						return null;
					}
				}
				else
				{
					return null;
				}
			}
			else
			{
				return null;
			}
		}
    @Override
	public void deleteUserById(Long id) {
		User user = userRep.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " does not exist."));

	    // Remove the association with roles
	    user.getRoles().clear();
		userRep.deleteById(id);
	}
    @Override
    public Role saveRole(Role r) {
       // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return roleRep.save(r);
    }
    @Override
	public Role updateRole(Role l) {
    	return roleRep.save(l);
	}
    @Override
	public void deleteRoleById(long id) {
		roleRep.deleteById(id);
		
	}
    @Override
    public User addRoleToUser(long id, Role r) {
        User usr = userRep.findUserById(id);

        List<Role> roles = usr.getRoles();
        roles.add(r);

        usr.setRoles(roles);

        return userRep.save(usr);
    }


    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }
    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }


    @Override
    public User findUserById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRep.findAll();
    }
    @Override
    public Role findRoleById(Long id) {
        return roleRep.findRoleById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRep.deleteByUserId(id);
    }
    @Override
    public User removeRoleFromUser(long id,Role r)
    {
        User user=userRep.findUserById(id);
        List<Role> listOfrole=user.getRoles();

        listOfrole.remove(r);
        userRep.save(user);
        return user;




    }
 

	

	@Override
	public List<User> getUsers() {
		return userRep.findAll();

	}
	
	
}
