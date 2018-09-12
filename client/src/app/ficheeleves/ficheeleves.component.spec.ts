import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheelevesComponent } from './ficheeleves.component';

describe('FicheelevesComponent', () => {
  let component: FicheelevesComponent;
  let fixture: ComponentFixture<FicheelevesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheelevesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheelevesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
