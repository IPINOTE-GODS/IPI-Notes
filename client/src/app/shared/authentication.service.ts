import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Response } from '@angular/http';
//import{ AppConstants} from '../app/constants'

@Injectable(/*{
  providedIn: 'root'
}*/)
export class AuthenticationService {
    
    isLoggedIn : any;
    currentUser: any;
 
    constructor(private _htc:HttpClient) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.isLoggedIn = this.currentUser && this.currentUser.token;
    }
	login(username: string, password: string): Observable<boolean> {

        const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

        return this._htc.post(
            'http://localhost:8080/authenticate', 
            JSON.stringify({username: username, password: password }),
            { headers: headers }
        )
		.map((response: any/*Response*/) => {
			// login successfully, if there is a jwt token in the response
			let token = (response != false);//response.json() && response.json().token;
			if (token) {
				//set the token property for validate token in the app.
				this.isLoggedIn = token;

                console.log(response);

                this.currentUser = {
                    username: username,
                    token: token,
                    id: response.id,
                    userType: response.userType
                };
				//store username and jwt token in local storage to keep user logged in between page refreshes.
				localStorage.setItem('currentUser', JSON.stringify(this.currentUser));

				//returns true to indicate successful login
				return true;
			} else {
				// returns false to indicate failed login
                return false;
            }
        });
	}

	logout(): void {
		// clear token remove user from local storage to log user out.
		this.isLoggedIn = null;
        this.currentUser = null;
		localStorage.removeItem('currentUser');
    }
}