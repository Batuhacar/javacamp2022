using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace YouTubeEgitim
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int sayi1 = 10;
            int sayi2 = 20;
            sayi1 = sayi2;
            sayi2 = 100;
            Console.WriteLine(sayi1);

            int[] sayilar1 = new[] { 1, 2, 3 };
            int[] sayilar2 = new[] { 10, 20, 30 };
            sayilar1 = sayilar2;
            sayilar2[1] = 1000;
            Console.WriteLine(sayilar1[1]);

            CreditManager creditManager = new CreditManager();

            creditManageer.Save();
            creditManageer.Calculate();

            Customer customer = new Customer(); //örneğini oluşturmak, instance oluşturmak, instance creation
            customer.Id = 1;
            customer.FirstName = "Batuhan";
            customer.LastName = "Acar";
            customer.City = "Ankara";

            CustomerManager customerManager = new CustomerManager(new Customer(), new TeacherCreditManager());
            customerManager.GiveCredit();
            customerManager.Save();
            customerManager.Delete();



            Company company = new Company();
            company.Id = 1;
            company.VergiNo = "12";

            Person person = new Person();
            person.City = "İstanbul";
            person.NationalIdentity = "15778879";

            Console.ReadLine();
        }
    }

    class CreditManager
    {
        public void Calculate()
        {
            Console.WriteLine("hesaplandı");
        }

        public void Save()
        {
            Console.WriteLine("kaydedildi");
        }
    }

    interface ICreditManager
    {
        void Calculate();
        void Save();

    }
    abstract class BaseCreditManager : ICreditManager
    {
        public abstract void Calculate();


        public void Save()
        {
            Console.WriteLine("kaydedildi");
        }
    }

    class TeacherCreditManager : BaseCreditManager, ICreditManager
    {
        public override void Calculate()
        {
            //hesaplamalar
            Console.WriteLine("Öğretmen kredisi hesaplandı");
        }


    }

    //SOLID

    class Customer
    {
        public Customer()
        {
            Console.WriteLine("Müşteri nesnesi başlatıldı");
        }
        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string City { get; set; }
    }

    class Person : Customer
    {
        public string NationalIdentity { get; set; }
    }

    class Company : Customer
    {
        public string VergiNo { get; set; }
    }

    // katmanlı mimari temelleri
    class CustomerManager
    {
        private Customer _customer;
        private ICreditManager _creditManager;
        public CustomerManager(Customer customer, ICreditManager creditManager)
        {
            _customer = customer;
            _creditManager = creditManageer;
        }
        public void Save()
        {
            Console.WriteLine("Müşteri kaydedildi  " + _customer.FirstName);
        }
        public void Delete()
        {
            Console.WriteLine("Müşteri silindi  " + _customer.FirstName);
        }

        public void GiveCredit()
        {
            _creditManager.Calculate();
            Console.WriteLine("Kredi verildi");
        }
    }
}
