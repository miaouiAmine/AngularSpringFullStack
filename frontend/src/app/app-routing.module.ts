import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import {CreeCodeComponent} from "./CreeCode/CreeCode.component";
import {AllCodesComponent} from "./all-codes/all-codes.component";
import {UtilisationComponent} from "./utilisation/utilisation.component";
import {AjouterCouponComponent} from "./ajouter-coupon/ajouter-coupon.component";
import {GetAllCouponsComponent} from "./get-all-coupons/get-all-coupons.component";
import {GestionUtilisateursComponent} from "./gestion-utilisateurs/gestion-utilisateurs.component";
import {AchatsComponent} from "./achats/achats.component";
import {UseCodeComponent} from "./use-code/use-code.component";
import {CreePortMComponent} from "./cree-port-m/cree-port-m.component";
import {AchteCouponComponent} from "./achte-coupon/achte-coupon.component";
import {AchatsPersoComponent} from "./achats-perso/achats-perso.component";


const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'user',
        component: UserComponent
    },

    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
  {
    path: 'Creation du code',
    component: CreeCodeComponent
  },

  {
    path: 'AllCodes',
    component: AllCodesComponent
  },
  {
    path: 'UtilisationDesCodes',
    component: UtilisationComponent
  },
  {
    path: 'AjouterCoupon',
    component: AjouterCouponComponent
  },

  {
    path: 'getAllCoupons',
    component: GetAllCouponsComponent
  },
  {
    path: 'gestionUtilisateurs',
    component: GestionUtilisateursComponent
  },
  {
    path: 'Achats',
    component: AchatsComponent
  },
  {
    path: 'utiliserCode',
    component: UseCodeComponent
  },

  {
    path: 'creePortM',
    component: CreePortMComponent
  },
  {
    path: 'achterCoupon',
    component: AchteCouponComponent
  },
  {
    path: 'Tous Les Achats',
    component: AchatsPersoComponent
  },

    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
