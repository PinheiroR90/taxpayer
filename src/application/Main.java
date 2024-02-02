package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Running Application");
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i = 0; i<n ; i++){
            System.out.println("Tax payer #"+(i+1)+" data:");
            System.out.print("Individual or company (i/c)? ");
            String opt = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            switch (opt){
                case "i":
                    System.out.print("Health expenditures: ");
                    double healthExpenditures = sc.nextDouble();
                    list.add(new Individual(name,anualIncome,healthExpenditures));
                    break;
                case "c":
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();
                    list.add(new Company(name,anualIncome, numberOfEmployees));
                    break;
                default:
                    System.out.println("Nenhuma opção válida!");
                    break;
            }
        }
        System.out.println("TAXES PAID:");
        for(TaxPayer taxPayer: list){
            System.out.println(taxPayer.getName()+": $ "+String.format("%.2f",taxPayer.tax()));
        }

        System.out.println();
        double sumTax = 0.0;
        for (TaxPayer taxPayer: list){
           sumTax += taxPayer.tax();
        }
        System.out.println("TOTAL TAXES: $ "+ String.format("%.2f",sumTax));
    }
}
