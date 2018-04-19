import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EtudiantService {
    public API = '//localhost:8080';
    public ETUDIANT_API = this.API + '/etudiants';

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.http.get(this.ETUDIANT_API + '/all');
    }

    get(id: string) {
        return this.http.get(this.ETUDIANT_API + '/' + id);
    }

    save(etudiant: any): Observable<any> {
        let result: Observable<Object>;
        if (etudiant['href']) {
            result = this.http.put(etudiant.href, etudiant);
        } else {
            result = this.http.post(this.ETUDIANT_API, etudiant);
        }
        return result;
    }

    remove(href: string) {
        return this.http.delete(href);
    }
}