package com.sunil.StaffMicroservice.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.sunil.StaffMicroservice.Entity.Staff;
import com.sunil.StaffMicroservice.Repository.StaffRepository;

@TestInstance(Lifecycle.PER_CLASS)
class StaffServiceImplTest {
	private StaffRepository staffRepository;
	private StaffServiceImpl staffServiceImpl;
	private Staff staff;
	
	@BeforeAll
	void setup() {
		staffServiceImpl = new StaffServiceImpl() ;
		staffRepository = mock(StaffRepository.class);
		staffServiceImpl.staffRepository = staffRepository;
		staff = new Staff(1, "sunil","varma","9951235979");
		
	}


	@Test
	@DisplayName("saving existing Staff")
	void testSaveStaff1 () {
		String staffPhNo = staff.getStaffPhNo();
		when(staffRepository.findByStaffPhNo(staffPhNo)).thenReturn(staff);
		
		Exception thrown = assertThrows(Exception.class, () -> staffServiceImpl.saveStaff(staff));
		assertEquals("staff data already exists",thrown.getMessage());
	}
	
	@Test
	@DisplayName("saving existing staff")
	void testSaveStaff2() throws Exception {
		String staffPhNo = staff.getStaffPhNo();
		when(staffRepository.findByStaffPhNo(staffPhNo)).thenReturn(null);
		when(staffRepository.save(staff)).thenReturn(staff);
		
		assertEquals(staff, staffServiceImpl.saveStaff(staff));
	}

}