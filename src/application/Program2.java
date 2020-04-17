package application;


import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===Teste 01: department findById ===");
		
		Department dep = departmentDao.findById(1);
		System.out.println(dep);


		System.out.println("\n===Teste 02: department findAll ===");

		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===Teste 03: department insert ===");

		Department newDepartment = new Department (null, "BackStage");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id= " + newDepartment.getId());
		
		System.out.println("\n===Teste 04: department update ===");
		
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Mandelao");
		departmentDao.update(dep2);
		System.out.println("Update completed!");
		

		System.out.println("\n===Teste 06: department delete ===");
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Insira ID para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
