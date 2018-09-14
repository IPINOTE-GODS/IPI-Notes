import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { LocationStrategy , PathLocationStrategy } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

// ===== OUR SERVICES ===== //
import { EtudiantService } from './shared/etudiant/etudiant.service';
import { EnseignantService } from './shared/enseignant/enseignant.service';
import { ModuleService } from './shared/module/module.service';
import { PromoService } from './shared/promo/promo.service';
import { AuthenticationService } from './shared/authentication.service';
import { AuthGuard } from './shared/auth-guard.service';
import { GiphyService } from './shared/giphy/giphy.service';

// ===== @ANGULAR/MATERIAL MODULES ===== //
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatCheckboxModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { EtudiantListComponent } from './etudiant-list/etudiant-list.component';
import { EtudiantEditComponent } from './etudiant-edit/etudiant-edit.component';
import { PromoListComponent } from './promo-list/promo-list.component';
import { PromoEditComponent } from './promo-edit/promo-edit.component';
import { ModulesListComponent } from './modules-list/modules-list.component';
import { FicheelevesComponent } from './ficheeleves/ficheeleves.component';
import { ModulesEditComponent } from './modules-edit/modules-edit.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';



const appRoutes: Routes = [
    {
        path: '',
        redirectTo: 'index',
        pathMatch: 'full'
    },
    {
        path: 'index',
        component: LoginComponent
    },
    {
        path: '',
        //canActivate: [AuthGuard],
        children: [
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
        ]
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
    ModulesEditComponent,
    LoginComponent,
    UserComponent
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
    MatCheckboxModule,

    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EtudiantService, EnseignantService, ModuleService, PromoService, AuthenticationService, AuthGuard, GiphyService,    { provide: LocationStrategy, useClass: PathLocationStrategy }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
