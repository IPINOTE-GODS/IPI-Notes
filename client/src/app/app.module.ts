import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { LocationStrategy , PathLocationStrategy } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

// ===== OUR SERVICES ===== //
import { EtudiantService } from './shared/etudiant/etudiant.service';
import { GiphyService } from './shared/giphy/giphy.service';

// ===== @ANGULAR/MATERIAL MODULES ===== //
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { EtudiantListComponent } from './etudiant-list/etudiant-list.component';
import { EtudiantEditComponent } from './etudiant-edit/etudiant-edit.component';
import { PromoListComponent } from './promo-list/promo-list.component';
import { PromoEditComponent } from './promo-edit/promo-edit.component';



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
    }
];

@NgModule({
  declarations: [
    AppComponent,
    EtudiantListComponent,
    EtudiantEditComponent,
    PromoListComponent,
    PromoEditComponent
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
  providers: [EtudiantService, GiphyService,    { provide: LocationStrategy, useClass: PathLocationStrategy }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
