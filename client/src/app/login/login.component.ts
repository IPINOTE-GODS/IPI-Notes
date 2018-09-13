import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthenticationService} from '../shared/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

loginForm;
model:any ={};
public errorMsg='';

  constructor(private _fbuilder:FormBuilder,
  private route:Router,
  private _authService:AuthenticationService) { 
  this.loginForm = _fbuilder.group({
	  username:['',[Validators.required, Validators.email]],
      password: ['', Validators.required, Validators.minLength(6)]
  });
  }

  ngOnInit() {
	this._authService.logout();   
  }

  login(user){
	      if (this.loginForm.valid) {
      if(this.loginForm.username !== undefined && this.loginForm.username !== null &&
        this.loginForm.password !== undefined && this.loginForm.password !== null){
          //Call Login service for validate username and password.
          this._authService.login(this.loginForm.username, this.loginForm.password)
            .subscribe(result => {
              if (result === true) {
                  // login successful
                  this.route.navigate(["user"]);
              } else {
                  // login failed
                  this.errorMsg = 'Username or password is incorrect.';
              }
          });  
	 }
	}
	    else{
      this.errorMsg = 'login failed, Please try again!';
  }
}
}
