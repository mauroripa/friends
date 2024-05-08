-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 08, 2024 alle 12:18
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `friends`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'Molly', 'Ciao7'),
(2, 'Chiara', '12345');

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id_categoria` int(11) NOT NULL,
  `nome_categoria` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`id_categoria`, `nome_categoria`) VALUES
(2, 'Personaggi'),
(3, 'Location'),
(6, 'Gadget'),
(7, 'Backstage');

-- --------------------------------------------------------

--
-- Struttura della tabella `contenuti`
--

CREATE TABLE `contenuti` (
  `id_contenuto` int(11) NOT NULL,
  `titolo` varchar(60) NOT NULL,
  `descrizione` longtext NOT NULL,
  `fk_id_categoria` int(11) NOT NULL,
  `sotto_descrizione` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `contenuti`
--

INSERT INTO `contenuti` (`id_contenuto`, `titolo`, `descrizione`, `fk_id_categoria`, `sotto_descrizione`) VALUES
(27, 'Ross Geller', 'Fratello di Monica, è un geek, paleontologo, cade in situazioni surreali soprattutto nei rapporti amorosi: la serie inizia con il suo matrimonio appena fallito perché sua moglie Carol, aveva appena scoperto di essere lesbica ed era andata a vivere con la sua nuova ragazza, Susan. Il difficile rapporto \"a tre\" di Ross con Carol e Susan sarà un tema ricorrente della serie. Alla fine della prima stagione nasce suo figlio, di nome Ben. Il nome viene suggerito a Susan e Ross da Phoebe, dopo che sono rimasti rinchiusi in uno sgabuzzino.', 2, NULL),
(28, 'Joey Tribbiani', 'È uno pseudo-attore di soap opera e spot pubblicitari, dalla fame proverbiale; è caratterizzato da una ottusità surreale, che porta spesso nel telefilm a gag esilaranti. Ha parecchio successo con le donne, ma le sue relazioni sono sempre senza un serio coinvolgimento sentimentale. È di origini italiane. Nell\'ottava stagione si prende una cotta non corrisposta per Rachel. I due si mettono insieme nella decima stagione, quando stavolta è Rachel ad avere una cotta per lui, ma si lasciano subito dopo perché si accorgono di essere troppo amici.', 2, NULL),
(29, 'Monica Geller', 'Sorella di Ross, appare come una maniaca dell\'ordine e della pulizia, incline alla competizione ed ostile alla sconfitta. Da adulta è una ragazza filiforme, ma da adolescente era obesa; la sua passione culinaria l\'ha resa adesso una cuoca apprezzata, al punto da divenire Chef del ristorante \"Alessandro\'s\", un ristorante italiano a cui inizialmente attribuisce una pesante critica. Nel corso della serie ha due storie importanti: con Richard Burke (interpretato da Tom Selleck), un affascinante oculista di vent\'anni più vecchio, amico di famiglia, e con Chandler Bing, che comincia semplicemente come un divertimento, quando sono tutti a Londra per il matrimonio di Ross con Emily, ma che diventa qualcosa di serio quando i due scoprono di amarsi. Nella settima stagione i due si sposeranno dopo due anni di relazione.', 2, NULL),
(30, 'Rachel Green', 'Appare, soprattutto nei primi episodi, come una ragazza molto agiata e viziata, incapace di eseguire semplici mansioni. Per voglia di indipendenza e necessità lavorerà come cameriera nel bar frequentato sia da lei che dai suoi amici, il \"Central Perk\". Amante della moda, riuscirà poi a fondere questa sua passione con un lavoro ben retribuito prima da Bloomingdale\'s e in seguito da Ralph Lauren. Durante la seconda stagione ha un\'importante storia con Ross, che era segretamente innamorato di lei dal liceo. Nella terza stagione chiede un periodo di riflessione a Ross, che si era mostrato ultimamente troppo geloso nei suoi confronti, e dopo aver scoperto che è andato a letto con un\'altra lo lascia, rimanendo furiosa con lui per tutto il resto della serie.', 2, NULL),
(31, 'Chandler Bing', 'Amico di Ross dal college, è il personaggio dalle battute più ciniche e sarcastiche; lavora nel suo grigio mondo di consulenti ed analisti. Odia il giorno del Ringraziamento a causa dei genitori che gli parlarono del loro divorzio proprio in quel giorno, quando lui era ancora piccolo; il suo carattere è segnato dal padre transessuale e gestore di un locale di spogliarelli per gay a Las Vegas e vive in conflittualità con la madre che è scrittrice di romanzi a sfondo erotico. Ha per più volte durante le prime stagioni una relazione con Janice, una ragazza che gli altri trovano fastidiosissima, che ricorrerà alcune volte anche nelle ultime stagioni, per qualche apparizione sporadica. Nella settima stagione si sposa con Monica Geller. Nella nona stagione per sbaglio accetta di trasferirsi a Tulsa; una volta là capisce di odiare il suo lavoro e così si licenzia, riuscendo alla fine a trovare un lavoro nella pubblicità.', 2, NULL),
(32, 'Phoebe Buffay', 'Viene, spesso forzatamente ai limiti della credibilità, rappresentata come una persona completamente fuori dagli schemi. Vegetariana, segnata da una infanzia drammatica con madre suicida in cui viveva per strada, lavora come massaggiatrice e si diletta a cantare canzoni non-sense accompagnata dalla chitarra nel Central Perk, il bar frequentato spesso dai sei amici. A volte crede di essere sensitiva; ha una sorella gemella, Ursula, con cui non ha nessun rapporto. È sempre alla ricerca delle sue origini, in quanto non ha mai conosciuto la vera identità del padre, che riuscirà a incontrare al funerale della adorata nonna.', 2, NULL),
(35, 'Central Perk', 'Central Perk: il cuore pulsante di amicizia, caffè e risate senza fine. Dove le tavole sono sempre riservate per Ross, Rachel, Chandler, Monica, Joey e Phoebe.', 3, NULL),
(36, 'Appartamento di Monica', 'L\'appartamento di Monica: Tra risate, pettegolezzi e momenti epici della vita quotidiana, questo è il luogo dove il cuore di Friends batte più forte.', 3, NULL),
(38, 'Appartamento di Joey e Chandlerd', 'L\'appartamento di Joey e Chandler: un rifugio di amicizia, risate e avventure senza fine. Dove il divano è il trono dei re del divertimento e la console è il cuore pulsante delle sfide epiche.', 3, NULL),
(39, 'Taxi di Phoebe', 'Il taxi di Phoebe: Tra le strade di New York, questo è il veicolo che porta la magia nella vita quotidiana, trasformando ogni viaggio in un momento di gioia e connessione umana.', 3, NULL),
(40, 'Fontana', 'La fontana:  In questo luogo emblematico di Central Park, ogni goccia d\'acqua porta con sé il riflesso di sei amici che hanno condiviso le gioie e le sfide della vita insieme.', 3, NULL),
(41, 'London Marriot Hotel', 'Lond Marriott Hotel: In questo elegante hotel londinese, ogni soggiorno è un capitolo indimenticabile della loro storia, fatto di risate, amore e incredibili colpi di scena.', 3, NULL),
(42, 'Il casinò di Las vegas', 'Il casinò di Las Vegas: un\'oasi di speranza e scompiglio nel deserto, dove i sei amici di Friends si ritrovano coinvolti in avventure caotiche e inaspettate. ', 3, NULL),
(43, 'Ultima Scena', 'Dopo 10 stagioni, 236 episodi e tantissime risate si conclude qui il nostro viaggio con Friends..Grazie di tutto.', 7, NULL),
(44, 'Risate sul set', 'Courteney Cox e Matthew Perry non riescono a trattenere le risate sul set di Friends! La chimica tra i due è contagiosa anche fuori dalla scena!', 7, NULL),
(45, 'Un selfie indimenticabile!', 'Il cast di Friends si unisce per un selfie di backstage! Loro ci fanno ridere sullo schermo, ma anche dietro le quinte sono un vero spasso! #FriendshipGoals', 7, NULL),
(46, 'Risate sul mitico divano!', 'Il trio dinamico di Friends si concede una pausa dal set e scoppia in una risata contagiosa sul mitico divano! I momenti di allegria tra le riprese rendono ancora più speciale questa iconica sitcom', 7, NULL),
(47, 'Sotto i riflettori', 'Courteney e David prendono parte a una scena allaperto sul set, mentre la cinepresa cattura ogni momento. Lavoro di squadra e professionalità si mescolano nel creare la magia dietro le quinte di questa amatissima serie!', 7, NULL),
(48, 'Scherzi nel backstage', 'Un momento di puro divertimento sul set di Friends! Matt gioca scherzosamente con i capelli di Lisa, creando unatmosfera leggera e allegra tra le riprese.', 7, NULL),
(49, 'Appartamento di Ross', 'Appartamento di Ross: Con il suo carattere accogliente e raffinato, questo è il rifugio perfetto per il paleontologo dai modi maldestri, dove la scienza e la sensibilità si fondono in armonia.', 3, NULL),
(50, 'LEGO Ideas Central Perk, Set con l Iconico Caffè e 7 Minifig', 'Il modellino da costruire LEGO Central Perk contiene l’iconico salotto con un divano, una poltrona, 2 sedie e un tavolo, che possono essere rimossi dal set per facilitare il gioco creativo.\r\n', 6, 'https://amzn.eu/d/cdywFzt'),
(51, 'Agenda', 'Quaderno ad anelli con copertina rigida, ideale per appunti o journaling.\r\nRacchiudi i tuoi pensieri e le tue idee con stile nel quaderno ad anelli con copertina rigida, caratterizzato dall\'iconico spioncino di Friends. Perfetto per prendere appunti o per journaling, questo quaderno è un omaggio al leggendario show televisivo che ha conquistato milioni di fan in tutto il mondo. Con un design accattivante e una costruzione resistente, è l\'accessorio ideale per esprimere la tua creatività e portare un tocco di nostalgia nella tua vita quotidiana!\r\n', 6, 'https://amzn.eu/d/7ZGKwHk'),
(52, 'Friends in Acciaio Inox', 'Con il suo design accattivante e il messaggio iconico, questa borraccia è più di un \r\nsemplice accessorio: è un pezzo di storia televisiva che puoi portare ovunque tu vada. \r\nUnisciti alla gang di Friends nel mantenere viva la memoria del loro leggendario show, \r\nmentre ti idrati con stile e nostalgia.\r\n', 6, 'https://amzn.eu/d/h9ucEQI'),
(53, 'Tote Bag con citazioni di Rachel Green', 'Porta con te l\'irresistibile stile e le citazioni indimenticabili di Rachel Green con questa tote bag. Perfetta per gli amanti di Friends, questa borsa è il regalo ideale per mostrare il tuo affetto per il leggendario show televisivo. Aggiungi un tocco di glamour alla tua giornata con questa borsa che cattura lo spirito e il fascino della moda di Rachel. Pratica ed elegante, è l\'accessorio ideale da portare in ufficio o per affrontare la routine quotidiana con stile.\r\n', 6, 'https://amzn.eu/d/a7XtUOD'),
(54, 'Morbida coperta con stampa di Monica Geller ', 'Crea un\'atmosfera accogliente e nostalgica nella tua casa con la coperta morbida di Monica Geller. Questa coperta è realizzata con materiali di alta qualità che ti avvolgeranno in un abbraccio di comfort e calore mentre ti immergi nei ricordi delle avventure della gang di New York. Un must-have per tutti i veri nostalgici e amanti della serie che desiderano portare un pezzo del loro show preferito nella loro vita quotidiana.\"\r\n', 6, 'https://amzn.eu/d/f5cGj4m'),
(55, 'Funko Bitty Pop! Friends + Mini Figura Misteriosa a Sorpresa', 'Ideali per gli appassionati di fumetti, film e serie, questi Bitty Pops! da collezione regalano emozioni e gioia in ogni occasione, affascinando sia i bambini che gli adulti.sono perfetti per compleanni ed eventi speciali, rendendo ogni occasione magica e memorabile per grandi e piccini.\r\nPossibilità di scartare un Hyper Rare (1/6) Joey Tribbiani (Cowboy), Hyper Rare (1/6) Phoebe Buffay (Music Video), Rare (1/3) Phoebe Buffay (Halloween Costume), and Rare (1/3) Joey Tribbiani (in Chandler’s clothes); abbraccia l\'emozione di collezionare minifigure uniche.', 6, 'https://amzn.eu/d/6nCs0r1'),
(56, 'Monopoly: Friends the TV Series Edition Gioco da tavolo', 'Woo-pah! Ama la serie TV Friends? Preparati per il gameplay Monopoly con situazioni e luoghi memorabili dalla leggendaria sitcom Friends.\r\nGli spazi di gioco presentano scene e temi che i fan riconosceranno tra cui Relaxi Taxi, All the Candy, Ross Teeth e Holiday Armadillo.\r\n', 6, 'https://amzn.eu/d/dcyhpxM'),
(57, 'LEGO Friends Phoebe Buffay Minifigure Portachiavi', 'Riaccendi i ricordi delle scene esilaranti della classica sitcom televisiva Friends con questo portachiavi di Phoebe LEGO®. Fissata a un resistente anello e catena di metallo, la minifigure di Phoebe Buffay è vestita proprio come il personaggio durante le sue esibizioni al Central Perk Café. Una splendida idea regalo per qualsiasi appassionato di Friends, è facile da applicare alle chiavi o allo zaino per portare sempre con te la tua stravagante amica.', 6, 'https://amzn.eu/d/1Yim7yJ'),
(58, 'Zerbino Antiscivolo Central Perk', 'Sorprendi le persone a te care con questo fantastico zerbino della celebre serie americana Friends. Uno dei prodotti di punta della nostra linea di decorazione per la casa, creato per i clienti piú esigenti. Fabbricato in fibra di cocco naturale e con una base antiscivolo. Utilizzalo sia dentro che fuori dalla casa per impedire l\'entrata di polvere, fango o sporco in generale. Decorare la tua casa non è mai stato cosí facile e divertente!', 6, 'https://amzn.eu/d/je00vaz'),
(59, 'Set da 6 tazzine per il caffè', 'Originale set di 6 tazzine per il caffè della divertentissima serie americana Friends. Ogni tazzina ha il nome di uno dei protagonisti. Il set include un portatazzine in metallo molto utile e comodo. Non te lo perdere!! Divertiti a fare colazione ricordando tutti gli episodi più divertenti della serie tv!\r\n', 6, 'https://amzn.eu/d/2ZfGDYD'),
(60, 'Tazza in ceramica Friends', 'Prodotto originale, verificato da rappresentanti ufficiali Friends.\r\nLa ceramica di alta qualità e una delle categorie di classe più alte disponibili tra le tazze garantiscono una lavorazione precisa, comfort d\'uso e lunga durata del prodotto. La grafica incorporata nella struttura della tazza ne garantisce un\'elevata resistenza a graffi e abrasioni.', 6, 'https://amzn.eu/d/gDgStCz');

-- --------------------------------------------------------

--
-- Struttura della tabella `galleria`
--

CREATE TABLE `galleria` (
  `id_galleria` int(11) NOT NULL,
  `foto` longtext NOT NULL,
  `fk_id_contenuto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `galleria`
--

INSERT INTO `galleria` (`id_galleria`, `foto`, `fk_id_contenuto`) VALUES
(64, 'backstage black&white.jpg', 46),
(188, 'Immagine WhatsApp 2024-05-03 ore 09.41.20_357b4815.jpg', 27),
(189, 'Immagine WhatsApp 2024-05-03 ore 09.44.02_2b35b4dd.jpg', 28),
(190, 'Immagine WhatsApp 2024-05-03 ore 09.44.30_b0807d83.jpg', 29),
(191, 'Immagine WhatsApp 2024-05-03 ore 09.45.34_34b3711b.jpg', 30),
(192, 'Immagine WhatsApp 2024-05-03 ore 09.46.01_dda44574.jpg', 31),
(193, 'Immagine WhatsApp 2024-05-03 ore 09.45.08_6244ccb1.jpg', 32),
(194, 'Friends_ Rachel Get her First Paycheck from Central Perk (Season 1 Clip) _ TBS.mp4', 35),
(195, 'Monica Deep Cleaned Joey\'s Apartment _ Friends.mp4', 36),
(196, 'Friends Cafe\' - Ross .mp4', 39),
(197, '\'I\'ll Be There For You\' (Friends Theme Song).mp4', 40),
(198, 'The London Marriott Grosvenor Square on Friends.mp4', 41),
(199, 'The Casino Lurker _ Friends.mp4', 42),
(200, 'Friends - Sigla.mp4', 38),
(201, 'ultima scena.jpg', 43),
(203, 'backstage selfie 2.jpg', 45),
(204, 'backstage esternomod.jpg', 47),
(205, 'backstage B&W.jpg', 48),
(206, 'chandler .mp4', 49),
(207, '71bfL8B4azL._AC_SY450_.jpg', 50),
(208, '71Qy+5oS1dS._AC_SL1500_.jpg', 50),
(209, '81cutIwgWuS._AC_SY450_.jpg', 50),
(210, '81SWQkEU3VS._AC_SY450_.jpg', 50),
(211, '916e0NNv+WS._AC_SY450_.jpg', 50),
(212, 'Quaderno4.jpg', 51),
(213, 'Quaderno5.jpg', 51),
(214, 'Borraccia1.jpg', 52),
(215, 'Borraccia2.jpg', 52),
(216, 'Borraccia3.jpg', 52),
(217, 'Borsa1.jpg', 53),
(218, 'Borsa2.jpg', 53),
(219, 'Borsa3.jpg', 53),
(220, 'Borsa4.jpg', 53),
(221, 'Coperta1.jpg', 54),
(222, 'Coperta2.jpg', 54),
(223, 'Coperta3.jpg', 54),
(224, 'funk1.jpg', 55),
(225, 'funk3.jpg', 55),
(226, 'funk4.jpg', 55),
(227, 'funk5.jpg', 55),
(228, 'funk6.jpg', 55),
(229, 'funko7.jpg', 55),
(230, 'funko8.jpg', 55),
(231, 'funko9.jpg', 55),
(232, 'funko10.jpg', 55),
(233, 'funko11.jpg', 55),
(234, 'mon1.jpg', 56),
(235, 'mon2.jpg', 56),
(236, 'mon3.jpg', 56),
(237, 'mon4.jpg', 56),
(238, 'porta1.jpg', 57),
(239, 'porta2.jpg', 57),
(240, 'porta3.jpg', 57),
(241, 'zerb1.jpg', 58),
(242, 'zerb2.jpg', 58),
(243, 'zerb3.jpg', 58),
(244, 'tazzina1.jpg', 59),
(245, 'tazzina2.jpg', 59),
(246, 'tazzina3.jpg', 59),
(247, 'tazzina4.jpg', 59),
(248, 'Tazza1.jpg', 60),
(249, 'tazza2.jpg', 60),
(250, 'tazza3.jpg', 60),
(251, 'due persone back stage.jpg', 44);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indici per le tabelle `contenuti`
--
ALTER TABLE `contenuti`
  ADD PRIMARY KEY (`id_contenuto`),
  ADD KEY `categorie` (`fk_id_categoria`);

--
-- Indici per le tabelle `galleria`
--
ALTER TABLE `galleria`
  ADD PRIMARY KEY (`id_galleria`),
  ADD KEY `fk_id_contenuto` (`fk_id_contenuto`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `contenuti`
--
ALTER TABLE `contenuti`
  MODIFY `id_contenuto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT per la tabella `galleria`
--
ALTER TABLE `galleria`
  MODIFY `id_galleria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `contenuti`
--
ALTER TABLE `contenuti`
  ADD CONSTRAINT `categorie` FOREIGN KEY (`fk_id_categoria`) REFERENCES `categorie` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `galleria`
--
ALTER TABLE `galleria`
  ADD CONSTRAINT `galleria_ibfk_1` FOREIGN KEY (`fk_id_contenuto`) REFERENCES `contenuti` (`id_contenuto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
