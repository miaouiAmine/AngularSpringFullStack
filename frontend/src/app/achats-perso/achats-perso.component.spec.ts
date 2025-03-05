import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AchatsPersoComponent } from './achats-perso.component';

describe('AchatsPersoComponent', () => {
  let component: AchatsPersoComponent;
  let fixture: ComponentFixture<AchatsPersoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AchatsPersoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AchatsPersoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
