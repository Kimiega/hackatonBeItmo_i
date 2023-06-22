import {Achievement} from "entities/achievment";
import {Event} from "entities/event"
import {Task} from "entities/task";

import {BeItmo} from "./api/be-itmo/be-itmo-type"

export const sampleEvents = [
  {
    labelUrl : null,
    title : "ITMO.LiVE 2023",
    description :
        "каждый год, летом, Университет ИТМО устраивает традиционную церемонию чествования выпускников. На празднике выпускники не только облачаются в мантии и получают заветный диплом, но также посещают интерактивные зоны, фотозоны и наслаждаются концертной программой, подготовленной специально для них.",
    beItmoType : BeItmo.Friendly,
    date : "8/07/2023",
  },
  {
    labelUrl : null,
    title : "Корпоративный выезд ССК «Кронверкские барсы»",
    description :
        "Выезд актива ССК КБ в Ягодное на сутки. В рамках данного выезда участников ждёт отдых на свежем воздухе, спортивные активности, игры на сплочение, костёр, катание на лодках и многое другое.",
    beItmoType : BeItmo.Fit,
    date : "24/06/2023",
  },
  {
    labelUrl : null,
    title : "Хакатон Be ITMO: цифровой профиль счастья",
    description :
        "Прими участие в разработке нового программного решения для университета. Три дня интенсивной работы в команде, прокачка твоих скиллов и возможность реализовать свою идею в ИТМО.&nbsp;Под руководством менторов и экспертов тебе предстоит разработать концепцию и интерфейс Цифрового профиля счастья – системы управления здоровьем и благополучием студентов и сотрудников университета.Призовой фонд:1 место&nbsp;— 100 000 руб.2 место — 70 000 руб.3 место — 50 000 руб.Сроки:16 июня — окончание регистрации;17-18 июня — знакомство участников друг с другом;19 июня — старт хакатона;22 июня — финальный питч.Подробнее на сайте",
    beItmoType : BeItmo.Friendly,
    date : "19/06/2023",
  },
  {
    labelUrl : null,
    title : "ITMO.Water Way",
    description :
        "Секция спортивного туризма готова провести серию бесплатных прогулок на байдарках по каналам Санкт-Петербурга. В программу входит мастер-класс по гребле на байдарках.",
    beItmoType : BeItmo.Fit,
    date : "13/06/2023",
  },
  {
    labelUrl : null,
    title : "ITMO.TOUR.FEST",
    description :
        "Приглашаем студентов Университета ИТМО активно провести летние выходные в Ленинградской области. В программе вас ждут: мастер-классы по скалолазанию и водному туризму, соревнования и большая приключенческая гонка.",
    beItmoType : BeItmo.Fit,
    date : "9/06/2023",
  },
  {
    labelUrl : null,
    title : "Startup Aquarium",
    description :
        "На одной площадке соберутся представители экосистемы поддержки стартапов: корпораций, венчурные фондов, институты поддержки. В формате friends-talk приглашенные эксперты расскажут об актуальных возможностях для проектов, об успешно реализованных кейсах, о процессе отбора. У проектов будет возможность задать все уточняющие вопросы и познакомиться с экспертами лично.Проекты со всей России получат шанс представить свои технологии перед инвесторами и представителями корпораций. &nbsp;Программа:Меры поддержки студенческих проектовFriends Talk венчурных фондов Институты поддержкиРабота с корпорациями",
    beItmoType : BeItmo.Pro,
    date : "19/06/2023",
  },
  {
    labelUrl : null,
    title : "Мульт Субботник в Ягодном ",
    description :
        "О мульт-вселенной слишком мало известно. Мы нарушили стабильность Пространственно-временного континуума и теперь персонажи из совершенно разных миров оказываются в Ягодном. Им придётся объединиться ради общего блага всего лагеря и помочь лесу и домам оправиться от зимней спячки. Однако это ещё не всё и каждый герой сможет проявить свои спортивные, интеллектуальные, музыкальные и кулинарные навыки.",
    beItmoType : BeItmo.Eco,
    date : "29/04/23",
  },
] as Event[];

export const sampleTasks = [
  {
    title : "Миссия",
    description : "Посетить главный корпус на Кронверском проспекте",
    date : "01/02/03",
    experiense : 300,
    beItmoType : BeItmo.Open,
  },
  {
    title : "Миссия",
    description : "Посетить корпус на Ломоносова",
    date : "01/02/03",
    experiense : 300,
    beItmoType : BeItmo.Open,
  },
  {
    title : "Миссия",
    description : "Посетить мероприятие от университета",
    date : "01/02/03",
    experiense : 200,
    beItmoType : BeItmo.Friendly,
  },
  {
    title : "Миссия",
    description : "Воспользоваться самокатом, чтобы добраться до корпуса",
    date : "01/02/03",
    experiense : 400,
    beItmoType : BeItmo.Open,
  }
] as Task[];

export const sampleAchieves = [
  {
    labelUrl : null,
    title : "Я стал friendly",
    experience : 200,
    description : "Получи 1 уровень в направлении be friendly",
    beItmoType : BeItmo.Friendly,
  },
  {
    labelUrl : null,
    title : "Я стал healthy",
    experience : 200,
    description : "Получи 1 уровень в направлении be healthy",
    beItmoType : BeItmo.Healthy,
  },
  {
    labelUrl : null,
    title : "Преданный пользователь",
    experience : 550,
    description : "Ежедневно посетите my.itmo, на протяжении 10 дней",
    beItmoType : BeItmo.Open,
  },
  {
    labelUrl : null,
    title : "Активный",
    experience : 750,
    description : "Посетите 50 мероприятий",
    beItmoType : BeItmo.Friendly,
  },
  {
    labelUrl : null,
    title : "Один из нас",
    experience : 550,
    description : "Станьте членом клуба",
    beItmoType : BeItmo.Friendly,
  },
  {
    labelUrl : null,
    title : "К знаниям",
    experience : 200,
    description : "Проведи 5 часов в Главном Корпусе",
    beItmoType : BeItmo.Open,
  },
  {
    labelUrl : null,
    title : "Первый сезон",
    experience : 200,
    description : "Поступи на первый курс бакалавриата",
    beItmoType : BeItmo.Pro,
  },
  {
    labelUrl : null,
    title : "На спорте",
    experience : 550,
    description : "Посети 10 соревнований от Кронверкских Барсов",
    beItmoType : BeItmo.Fit,
  },
  {
    labelUrl : null,
    title : "LVL UP",
    experience : 200,
    description : "Получи 5 уровень профиля",
    beItmoType : BeItmo.Friendly,
  },
  {
    labelUrl : null,
    title : "Посетил eco",
    experience : 550,
    description : "Прими участие в 5 мероприятиях по направлению be eco",
    beItmoType : BeItmo.Eco,
  },
  {
    labelUrl : null,
    title : "Под защитой",
    experience : 550,
    description : "Пройди вакцинацию от гриппа, Covid-19 и других заболеваний",
    beItmoType : BeItmo.Healthy,
  }
] as Achievement[];