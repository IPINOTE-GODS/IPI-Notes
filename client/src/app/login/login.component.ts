import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Router} from '@angular/router';
import {AuthenticationService} from '../shared/authentication.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    loginForm:any ={};
    public errorMsg='';

    constructor(
        private route:Router,
        private _authService:AuthenticationService) { 
        /*this.loginForm = _fbuilder.group({
        username:['',[Validators.required, Validators.email]],
        password: ['', Validators.required, Validators.minLength(6)]
        });*/
    }

    ngOnInit() {
        this._authService.logout();   
    }

    login(form: any/*NgForm*/){
        //Call Login service for validate username and password.
        this._authService.login(form.username, form.password)
        .subscribe(result => {
            if (result != false) {
                // login successful

                const userType = this._authService.currentUser.userType;

                switch(userType) {
                    case "étudiant":
                        this.route.navigate(["ficheeleve"]);
                        break;
                    default:
                        this.route.navigate(["promo-list"]);
                }

            } else {
                // login failed
                this.errorMsg = 'Username or password is incorrect.';
            }
        });
    }
}