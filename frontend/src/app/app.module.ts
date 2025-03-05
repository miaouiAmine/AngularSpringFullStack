import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import {CreeCodeComponent} from './CreeCode/CreeCode.component';
import {GiftCodeService} from "./services/gift-code.service";
import { AllCodesComponent } from './all-codes/all-codes.component';
import { UtilisationComponent } from './utilisation/utilisation.component';
import {UtilisationService} from "./services/utilisation-service.service";
import { AjouterCouponComponent } from './ajouter-coupon/ajouter-coupon.component';
import {CouponService} from "./services/coupon.service";
import { GetAllCouponsComponent } from './get-all-coupons/get-all-coupons.component';
import { GestionUtilisateursComponent } from './gestion-utilisateurs/gestion-utilisateurs.component';
import { AchatsComponent } from './achats/achats.component';
import { UseCodeComponent } from './use-code/use-code.component';
import { CreePortMComponent } from './cree-port-m/cree-port-m.component';
import { AchteCouponComponent } from './achte-coupon/achte-coupon.component';
import { AchatsPersoComponent } from './achats-perso/achats-perso.component';






@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    CreeCodeComponent,
    AllCodesComponent,
    UtilisationComponent,
    AjouterCouponComponent,
    GetAllCouponsComponent,
    GestionUtilisateursComponent,
    AchatsComponent,
    UseCodeComponent,
    CreePortMComponent,
    AchteCouponComponent,
    AchatsPersoComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders,GiftCodeService,UtilisationService,CouponService],
  bootstrap: [AppComponent]
})
export class AppModule { }
