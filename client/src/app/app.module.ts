import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { LocationStrategy , PathLocationStrategy } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

// ===== OUR SERVICES ===== //
import { EtudiantService } from './shared/etudiant/etudiant.service';
import { ModuleService } from './shared/module/module.service';
import { GiphyService } from './shared/giphy/giphy.service';

// ===== @ANGULAR/MATERIAL MODULES ===== //
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { EtudiantListComponent } from './etudiant-list/etudiant-list.component';
import { EtudiantEditComponent } from './etudiant-edit/etudiant-edit.component';
import { PromoListComponent } from './promo-list/promo-list.component';
import { PromoEditComponent } from './promo-edit/promo-edit.component';
import { ModulesListComponent } from './modules-list/modules-list.component';
import { FicheelevesComponent } from './ficheeleves/ficheeleves.component';
import { ModulesEditComponent } from './modules-edit/modules-edit.component';



const appRoutes: Routes = [
    {
        path: '',
        redirectTo: '/CSS Commun',
        pathMatch: 'full'
    },
    {
        path: 'etudiant-list',
        component: EtudiantListComponent
    },
    {
        path: 'etudiant-add',
        component: EtudiantEditComponent
    },
    {
        path: 'etudiant-edit/:id',
        component: EtudiantEditComponent
    },
    {
        path: 'promo-list',
        component: PromoListComponent
    },
    {
        path: 'promo-add',
        component: PromoEditComponent
    },
    {
        path: 'promo-edit/:id',
        component: PromoEditComponent
    },
    {
        path: 'modules-list',
        component: ModulesListComponent
    },
    {
        path: 'modules-add',
        component: ModulesEditComponent
    },
    {
        path: 'modules-edit/:id',
        component: ModulesEditComponent
    },
    {
      path: 'ficheeleve',
      component:  FicheelevesComponent
    }
];

@NgModule({
  declarations: [
    AppComponent,
    EtudiantListComponent,
    EtudiantEditComponent,
    PromoListComponent,
    PromoEditComponent,
    ModulesListComponent,
    FicheelevesComponent,
    ModulesEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,

    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,

    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EtudiantService, ModuleService, GiphyService,    { provide: LocationStrategy, useClass: PathLocationStrategy }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
