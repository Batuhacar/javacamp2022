--Select (Seçerek çalıştır.)
--ANSII
Select ContactName Adi, CompanyName Sirketadi, City Sehir from Customers -- Aslında bir tablo.

Select * from Customers where City = 'Berlin' -- tek tırnakla yazılır isimler

--case insensitive
select * From Products where categoryId=1 or categoryId=3

select * From Products where categoryId=1 or unitPrice>=10

select * from Products where CategoryId=1 order by UnitPrice desc --default olarak ascending'dir zaten o yüzden "asc" yazmaya gerek yok, --descending için "desc" yazmak gerekir.

select count(*) Adet from Products --where CategoryId =2 --sayısını saymak için Product tablosundaki kaç adet ürün sayısı.

select categoryID, count(*) Adet from products where unitPrice > 20 group by CategoryID having count(*)<10 --group by kullandığımız zaman group by dediğimiz alanı girmek zorundayız. * olamaz. --öncelikle where uygulanır.

select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName --şu tablodan şunu getir şeklinde . ile yazılmalıdır.
from products inner join Categories --Category'lerin ve product'ların bir araya gelmiş şekli için "inner join" kullanırız.
on Products.CategoryID = Categories.CategoryID 
where Products.UnitPrice>10
--inner join sadece iki tabloda da eşleşen dataları getirir eğer eşleşmiyorsa getirmez!

--DTO (Data Transformation Object)

select * from Products p left join [Order Details] od --Boşluk doğru olmadığı için köşeli parantez içine alınır isimlendirmede yanlışlık olduğu için.
on p.ProductID = od.ProductID --left join solda olup sağda olmayanları da getir.. yani P'de olup Od'de olmayanları da getirebilirsin demek.

select * from Customers c left join Orders o --left join sayesinde hem inner join hem de sol da olup sağda olmayanları da getirebiliriz.
on c.CustomerID = o.CustomerID
where o.CustomerID is null

select * from Customers c left join Orders o --tam tersi yani sol dahil değil sağ dahil ve aynı zamanda ikisinde eşleşen right join işlemi
on c.CustomerID = o.CustomerID
where o.CustomerID is null
