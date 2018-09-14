import { TestBed, inject } from '@angular/core/testing';

import { EnseignantService } from './enseignant.service';

describe('EnseignantService', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            providers: [EnseignantService]
        });
    });

    it('should be created', inject([EnseignantService], (service: EnseignantService) => {
        expect(service).toBeTruthy();
    }));
});