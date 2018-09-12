import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModulesEditComponent } from './modules-edit.component';

describe('ModulesEditComponent', () => {
  let component: ModulesEditComponent;
  let fixture: ComponentFixture<ModulesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModulesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModulesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
