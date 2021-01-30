Bu ödevinizde kan bağışı merkezinize gelen bağışçılar ve kana ihtiyacı olanları  eşleştirip kaydını 
çizge(graph) üzerinde gösteren bir yazılım kodlayacaksınız. Kan merkezine gelen insanların Tc kimlik numarası,bağışçı,kan alıcı, kan grubu, RH bilgileri ile HIV, 
Hepatit B hastalık durumu bilgileri vardır. Bağışçılar ve kan verdiklerinin ilişkisi çizgeyle gösterilecek ve çizge komşuluk listesi ile tanımlanacaktır.
Ayrıca kan grubu ve RH'a göre kan bağışlayabilme için ayrıca bir çizge kullanılacak ve bağışçının kan alıcıya kan verebildiği bu çizgeden kontrol yapılarak belirlenecektir.

Oluşturacağınız insan sınıfında  TC kimlik numarası, bağışçı mı (boolean), kan alıcı mı (boolean), kan grubu RH(+ veya -),HIV (boolean) ve HepatitB(boolean) hastalığı ve 
kan alıcı ise öncelik sırası değişkenleri tanımlanmalıdır. İhtiyaç duyarsanız başka diğer fonksiyonlar tanımlayabilirsiniz.

Bir insan kan bağışçısı veya alıcı olabilir. Eğer insan hepatitB veya hıv var ise  bu insan bağışçı olamaz sadece kan alabilir.
Çizgeler yönlü olarak tanımlanacaktır.
Uygulamanız belirtilen yönlerde her iki çizgeyide düzgün bir şekilde oluşturmalıdır.

Uygulamanızda 4 işlemli bir menu oluşturacaksınız. İlk işlem insan ekleme olacaktır.(Kullanıcıdan insan nesnesinin değişkenlerini girmesi istenecektir.)
İkinci işlem girdi olarak verilen 2 insan  kan bağışı yapabiliyorsa kan bağış çizelgesi tanımlanarak  tabloya kayıt edilecektir.
Üçüncü işlemde kan grubu RH'a göre kan bağış ilişkisini gösteren çizge yazdırılacaktır.
Dördüncü işlemde kan bağış merkezine kayıt edilen herkesin kan bağışı ilişkisini gösteren çizge ekrana yazdıralacaktır.

Kan bağış merkezinde kan alımı başvuruları içerisinden seçim öncelikli kuyruk kullanılarak seçilecektir.
 