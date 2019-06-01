# English

## TV app

Implement a small Java application that demonstrates how the new *TV app* works! Check your implementation using the `Test` class (commenting out stuff is recommended at the beginning)!

The TV app provides a unified platform for watching films, tv shows, etc. You can watch content from multiple streaming providers within one app. You can subscribe to streaming services and start watching the content right away! For example, if you want to watch Game of Thrones, you do not need to go the App Store and install the HBO GO app, register, pay, etc., you only need to push a button and the TV app will automatically take care of everything: you can start watching the show. Of course you will need to go through some payment method in order for this to work, but don't worry, we have already taken care of that! Here's what **you** need to do:
* You need to create a `tv.Wallet` class, which will be used to pay in the TV app. The Wallet will communicate with the `tv.CreditCard` class (which we provided for you) in order to draw some cash each time you want to pay with your Wallet. The point is that the TV should not know how to handle a credit card, it only needs to know how to use a wallet.

  The Wallet shall keep track of your current funds in its implementation.

  The Wallet shall provide two methods. One for payment (let it be called `draw`), and one for topping up your wallet (`topUp`). You can find out the signature of these methods (parameters) if you look at the `testWallet` method in the `test.Test` class (provided to you).

  The `draw` method does not need to return anything, but it must check the current funds before letting anyone draw. Also it should check whether the amount to be drawn is a valid (positive) amount! If any of these checks fails, throw some exceptions (a user defined exception is worth extra points).

  The `topUp` method must create a `CreditCard` object given the proper card number, and then try to `charge` it the given amount (which should be positive, also to be checked). Since the `CreditCard` is a resource (note that it implements `AutoClosable`), make sure to close it properly after use!

* For the TV app to find shows, it needs providers called *channels*. Since we do not want to expose the implementation of these channels, we will need some common interface. Create a `tv.Channel` interface. The implementing classes of `tv.Channel` will be in a subpackage (more on that later).

  A Channel offers three things: its name, its price, and its list of shows that you can watch. These are provided by the methods `getName`, `getPrice`, and `getShows`. You are expected to use the `java.util.List` interface (with the appropriate generic argument, `tv.Show`, see below) and not some concrete class for the result type of `getShows`.

* Create a `tv.Show` class that represents a TV show. For this exercise it only needs one property, the title of the show. It should be the only argument to the constructor, and you should define a getter method for it as well. Also, a `toString` method would be nice to have (and is worth some extra points). Make sure that this class is immutable.

* In a new package, `tv.providers`, create three *package-private* concrete classes that implement the `Channel` interface. 
  These will be: `Starz`, `Showtime` and `HBO`. Each shall have the appropriate name returned on `getName`. Their prices are: 10, 7, 5 respectively (returned by `getPrice`). 
They shall all know which shows they provide. You can use a `List` for example. The shows will be fixed, so it is okay if you just fill up the lists in the constructor. If you want to avoid a lot of copy-pasting (and want to get some extra points), you should create an abstract superclass for these three channels that implements the common behaviour. 

  A `toString` method is optional (and is worth extra points).

  The following shows must be available on the channels:

  * `Starz`: *Outlander*, *Battlestar Galactica*
  * `Showtime`: *Shameless*
  * `HBO`: *Game of Thrones*,  *Westworld*

* Since the channels should not be duplicated, we need some way of instantiating them only once. In order to do that, you need to create a factory class. Name it `tv.providers.ChannelFactory`.

You should define an *enumeration type* `Provider`, which enumerates all possible channel providers (`HBO`, `SHOWTIME`, `STARZ`). (This type can be inside the `ChannelFactory` class.)

  The `ChannelFactory` class shall have only one, static, method (`getChannel`), which has a `Provider` parameter, and returns the corresponding `Channel` implementation. It is recommended to use a static field of type `java.util.Map`, which can map each enum value to the required `Channel` instance (a simple switch case is also acceptable but is worth less points).

* Finally, the `tv.TvApp` class is where all the fun happens. It has a reference to your `Wallet`, it keeps track of all available  channels, and it knows which one you have subscribed to (a `Map` from `Channel` to `Boolean` might be a good representation).

  The TvApp shall receive your Wallet on creation. It is also recommended to create the mapping from all available `Channel`s to `Boolean`s in the constructor (with `false` values).

  We want the user to be able to subscribe to a show without getting access to a concrete Channel, and therefore there must be a subclass of Show that is able to track which TvApp and Channel it belongs to. For this purpose, create a package-private class `tv.TvShowImpl` that extends `Show` and implements the `TvShow` interface (the latter is provided to you). If you wish, and know hot to do that, you can make `TvShowImpl` a private inner class inside class `tv.TvApp`.

TvShowImpl will have two constructor parameters: the title, which should be passed to the constructor of the superclass, and a `Channel` instance (saved in some field) that should correspond to the channel the show is available on.

   `TvShowImpl` needs to implement the following methods:

  * `isSubscribed`: Query the subscription status of the channel (queried from the `TvApp` class).
  *  `subscribe` : If the there is no active subscription on the channel, then draw enough money from the wallet to pay for the subscription. If no exception is thrown (there is enough money), set the subscription status of the channel to `true`.
  *  `getChannel`: Simple getter for the `channel` field.
  * `watch`: this has an `OutputStream` parameter. If there is no active subscription on the channel then throw an exception, otherwise create a `java.io.PrintWriter` instance from `OutputStream` object and print the following: `"You are watching TITLE on CHANNEL"` where *TITLE* is the title of the show and *CHANNEL* is the name of the channel. Do not forget to `flush()` the `PrintWriter` after use!

  The `TvApp` has two public methods called `browseAllShows` and `searchShow`. The first should return a List of all available shows from all `Channel` implementations (as `TvShow` instances), the latter shall have a `String` parameter for the title, return a `TvShow` if the search succeeds, and throw some exception otherwise.

# Hungarian

# JAVA gyakorlás


## TV app

A feladat egy olyan JAVA program írása, amely bemutatja egy *TV app* nevű alkalmazás működését. A (részben) kész megoldásod a melléket `Test` osztállyal ellenőrizheted. Részleges megoldás teszteléséhez, kommenteld ki a még nem kész programrészekre vonatkozó teszteket!

A forradalmi *TV app* új megközelítést visz a tévénézés világába, egységes platformot biztosítva tv-, film- és sorozatnézésre. Az alkalmazásban elérhető műsorokat egy gombnyomásra elindíthatjuk, és előfizethetünk a hozzájuk tartozó csatornára. *(Például, ha a legújabb Trónok harca részt szeretnéd megnézni, nem kell letöltened a HBO GO alkalmazást majd regisztrálni és fizetni, mivel az alkalmazás mindent elintéz helytted. Így azonnal nézni kezdheted.)* Természetesen, ezen funkciókhoz először meg kell adnod valamilyen fizetési módot, de minden más automatikus lesz. Hogy ez megvalósulhasson, a szükséges programrészeket Neked kell implementálni.


### `tv.Wallet`

Készíts egy `tv.Wallet` (*továbbiakban tárca*) osztály, amely az alkalmazáson belüli fizetést teszi lehetővé. Az tárca a `tv.CreditCard` osztállyal (*ezt mindenki előre megkapja a feladattal*) fog kommunikálni és pénzt kérni onnan, ha valamiért fizetnünk kell. Ez azért szükséges, hogy az alkalmazásnak ne kelljen közvetlenül bankkártyákat kezelnie, a fizetéshez elegendő legyen a csak tárcából "kivenni" a pénzt.

A tárca fogja nyilvántartani a rendelkezésre álló összegünket (*egy adattag formályában*).

Az osztálynak két metódusa van: egy a tárcából való fizetésre (`draw`), és egy a tárcába való pénz betételre (`topUp`). A metódusok paramétereinek típusát a mellékelt `test.Test` osztály `testWallet` függvényében leírt tesztek alapján határozd meg.

* A `draw` metódusnak nincs visszatérési értéke. A paraméterként kapott összegről először ellenőrzi, hogy nem-e nagatív, majd ha van elegendő pénz a tárcában, levonja a "kivett" összeget. Ha a kivenni kívánt összeg nagatív vagy nincs elegendő pénz a tárcában, kivételt dob (*plusz pontot ér, ha saját kivételt definiálsz err a célra*).
* A `topUp` metódus létrehoz egy `CreditCard` objektumot egy érvényes kártyaszámmal és a nem negatív összeggel, amivel meg szeretnénk terhelni a kártyát (*negatív összeg esetén ugyan úgy hibát kell dobni, mint az előző metódusban*). Mivel a `CreditCard` osztály egy erőforrás (implementálja a `AutoClosable` interfészt), a használat után fel kell szabadítani (*be kell zárni*).


### `tv.Channel`

A *TV app* alkalmazásban a műsorokat, műsor szolgáltatókon keresztül érhetjük el, akik a tartalmaikat saját "csatornájukon" teszik elérhetővé. Mivel a csatornák belső implementációját nem szeretnénk kiszivárogtatni vagy megszabni, szükség lesz egy közös interfésztre (`tv.Channel`) a velük való kommunikációhoz. *(A `tv.Channel` interfészt megvalósító osztályokat egy későbbi feladatrészben részletezzük.)*

Egy csatornának a három adatot kell biztosítania a következő metódusok segítségével:

* `getName()`, mely a csatorna nevével tér vissza
* `getPrice()`, mely a csatorna előfizetés árával tér vissza
* `getShows()`, mely a csatorna által kínált műsorok listájával tér vissza (*`java.util.List`-et kell használni a megfelelő típusparaméterrel: `tv.Show`, ld. lejjebb*)


### `tv.Show`

Készíts egy `tv.Show` osztályt, amely egy TV műsort fog reprezentálni. Az osztálynak egyetlen értéket kell ("*konstansként*") tárolnia: a műsor nevét. Ehhez rendelkezik egy műsornevet (*string*) váró konstruktorral és egy `getTitle` getter metódussal. *(A `toString` metódus felüldefiniálása plusz pontot ér.)* A tárolt névnek megváltoztathatatlannak kell lennie!


### `tv.providers.*`

Az elérhető szolgáltatók implementációja a `tv.providers` csomagba fog kerülni. Ez jelen esetben három, *package-private* osztály létrehozását jelenti a megadott csomagon belül: `Starz`, `Showtime` és `HBO`. A szolgáltatók csatirnáinak le lehet kérni a nevét, előfizetés árát valamint a műsorlistájukat (*ld.* `tv.Channel`).
 
 * `Starz`
 csatorna neve: *Starz*
 előfizetés ára: *10*
 műsorok: *Outlander*, *Battlestar Galactica*
 * `Showtime`
 csatorna neve: *Showtime*
 előfizetés ára: *7*
 műsorok: *Shameless*
 * `HBO`
 csatorna neve: *HBO*
 előfizetés ára: *5*
 műsorok: *Game of Thrones*, *Westworld*

Ezek az adatok -- jelen esetben -- nem fognak változni, így -- egymástól függetlenül -- közvetlenül az osztályok implementációjába is beleírhatjuk. *(Szebb megoldásként egy abszztrakt szülőosztályban definiálhatjuk az egységes metódusokat, plusz pont fejében. A szintén plusz pontot érő `toString` metódus felüldefiniálása szintén opcionális.)*


### `tv.providers.ChannelFactory`

Mivel egy csatornát csak egyszer szabad létrehozni (*két egyforma csatorna nem megengedett*), ezért létre kell hoznunk egy *publikus* csatornákat példányosító osztályt (`tv.providers.ChannelFactory`).

Ehhez szükség lesz továbbá egy `enum Provider` felsoroló is, mely tartalmazza a meglévő csatornáinkat (`HBO`, `SHOWTIME`, `STARZ`). *(A felsorolót a `ChannelFactory` osztályban is definiálhatod.)*

A `ChannelFactory` osztály egyetlen osztály szintű (*statikus*) `getChannel` metódussal rendelkezzen. A metódus egyetlen `Provider` típusú paramétert vár és visszatér a paraméterben megadott osztály egy példányával.

Ahhoz, hogy minden csatorna csak egyszer legyen példányosítva, hozz létre egy szintén *statikus*, *rejtett* `java.util.Map` típusú adattagot, melyben minden szolgáltatóhoz (*`Provider` értékei*) eltárolod a csatornája (*`Channel` implementációi*) egyetlen példányát. *(Alternatív megoldásként a switch-case szerkezet szintén elfogadott, de kevesebb pontot ér.)*


### `tv.TvApp`

Végül a `tv.TvApp` osztály implementációja következik. Ez az osztály fogja használni a tárcánkat, így adattag szinten rendelkeznie kell egy tárca (`Wallet`) objektummal, melyet konstruktor paraméterként kap meg. Szintén itt lesznek nyilvántartva az elérhető csatornák is és az is, hogy ezek közül melyekre fizettünk elő (*erre egy `Map<Channel,Boolean>` adatszerkezet jó választás lehet, melyet a konstruktorban inicializálhatunk `false` értékekre*).

Az osztály két publikus metódussal rendelkezik:

* `browseAllShows()`: visszatér az összes műsorral (`List<TvShow>`, *minden csatornát beleértve*)
* `searchShow(String)`: Egy műsor címet vár paraméterül és visszatér egy `TvShow` példánnyal ha van egyező nevű műsor; ellenkező esetben hibát dob


### `tv.TvShowImpl`

Azt szeretnénk elérni, hogy a felhasználó anélkül tudjon megnézni egy műsort, hogy foglalkoznia kelljen azzal, hogy melyik csatornán érhető el és előfizetett-e már oda. E célra szükség lesz egy "összekötő" (`tv.TvShowImpl`) osztályra, amely tartalmazza, hogy egy adott műsor melyik csatornához tartozik.

Hozz létre egy *package-private* `tv.TvShowImpl` osztályt, mely a `Show` osztályból származik és egyben implementálja a `TvShow` interfészt is (*utóbbit mindenki előre megkapja a feladattal*). *(A `TvShowImpl` osztályt privát beágyazott osztályként a `tv.TvApp` osztályba is elhelyezhető.)*

Az osztáy konstruktora két paramétert vár: a műsor címét (*string*, *a szülő osztályt is ezzel kell inicializálni /super/*) és a csatornát (*`Channel` objektum*) melyen az adott műsor elérhető.

Az implementálni kívánt `TvShow` interfész miatt, a következő metódusokat kell megvalósítani `TvShowImpl` osztályban:

* `isSubscribed()`: feliratkoztunk-e az adott műsor csatornájára
* `subscribe()`: ha még nem iratkoztunk fel az adott műsor csatornájára, akkor kiveszi a szükséges összeget a tárcából és feliratkozik (*az ezt vezető `Map`-be `true` értéket állít*) ha a volt elég pénzünk a művelethez (*azaz pénzkivétel során nem dobódott kivétel, ld. `tv.Wallet`*)
* `getChannel()`: getter metódus a konstruktorban kapott csatornához
* `watch(OutputStream)`: ha nem vagyunk feliratkozva a műsor csatornájára kivételt dob; ellenkező esetben létrehoz egy `java.io.PrintWriter` példányt a paraméterként kapott `OutputStream` stream objektummal és kiírja a `"You are watching TITLE on CHANNEL"` szöveget (*ahol a `TITLE` a műsor neve, a `CHANNEL` pedig a csatorna neve*)
*(Miután kiírtad az üzenetet, ne feledd meghívni a `flush()` metódust a példányosított `PrintWriter` osztályon.)*
