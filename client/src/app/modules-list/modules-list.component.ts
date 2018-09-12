import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { ModuleService } from '../shared/module/module.service';

@Component({
  selector: 'app-modules-list',
  templateUrl: './modules-list.component.html',
  styleUrls: ['./modules-list.component.css']
})
export class ModulesListComponent implements OnInit {

   constructor(
       private moduleService: ModuleService
       ) { }

   private modules: Array<any> = [];

   ngOnInit() {
       this.moduleService.getAll().subscribe(data => {
           this.modules = data;
       });

   }

}