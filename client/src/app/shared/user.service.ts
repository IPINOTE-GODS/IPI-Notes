import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import {AuthenticationService} from './authentication.service';
import {User} from '../user';
//import{ AppConstants} from '../app/constants'

@Injectable(/*{
  providedIn: 'root'
}*/)
export class UserService {
 _baseURL : "http://localhost:4200";
 private _headers = new HttpHeaders().set('Content-Type', 'application/json');

   constructor(private _htc:HttpClient, private authService: AuthenticationService) {
   
  }
  
   getUsers(): Observable<User[]> {
    const headers = this._headers.append('Authorization:', 'Bearer ' + this.authService._token);

    //Get users from REST API
    return this._htc.get<User[]>(this._baseURL, { headers : headers });
  }
}
