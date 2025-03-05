import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UseCodeComponent } from './use-code.component';

describe('UseCodeComponent', () => {
  let component: UseCodeComponent;
  let fixture: ComponentFixture<UseCodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UseCodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UseCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
