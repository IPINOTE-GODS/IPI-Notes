import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { ModuleService } from '../shared/module/module.service';
import { NgForm } from '@angular/forms';

@Component({
    selector: 'app-modules-edit',
    templateUrl: './modules-edit.component.html',
    styleUrls: ['./modules-edit.component.css']
})
export class ModulesEditComponent implements OnInit, OnDestroy {
    module: any = {};

    sub: Subscription;

    constructor(private route: ActivatedRoute,
        private router: Router,
        private moduleService: ModuleService) {

    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            const id = params['id'];
            if (id) {
                this.moduleService.get(id).subscribe((module: any) => {
                    if (module) {
                        this.module = module;
                        this.module.href = id;//module._links.self.href;
                    } else {
                        console.log(`Module with id '${id}' not found, returning to list`);
                        this.gotoList();
                    }
                });
            }
        });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    gotoList() {
        this.router.navigate(['/modules-list']);
    }

    save(form: NgForm) {
        this.moduleService.save(form).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

    remove(href) {
        this.moduleService.remove(href).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

}
