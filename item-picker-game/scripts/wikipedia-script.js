const { Client } = require('pg');
const { v4: uuidv4 } = require('uuid');

// PostgreSQL client setup
const client = new Client({
    user: 'postgres',
    host: 'localhost',
    database: 'choosr',
    password: 'postgres',
    port: 5432,
});

// Connect to PostgreSQL
client.connect();

// Wikipedia API endpoint
const wikiApiUrl = 'https://ru.wikipedia.org/w/api.php';

// Function to fetch description and title from Wikipedia
async function fetchDescription(title) {
    const response = await fetch(`${wikiApiUrl}?action=query&format=json&prop=description&titles=${encodeURIComponent(title)}`);
    const data = await response.json();
    const page = Object.values(data.query.pages)[0];

    const normalizedTitle = data.query.normalized ? data.query.normalized[0].to : title;
    const description = page.description || 'No description available';

    return { normalizedTitle, description };
}

// Function to insert data into PostgreSQL
async function insertData(title, description) {
    const id = uuidv4();
    await client.query('INSERT INTO items(id, item_title, description) VALUES($1, $2, $3)', [id, title, description]);
}

// Main function to process words
async function processWords(words) {
    for (const word of words) {
        const { normalizedTitle, description } = await fetchDescription(word);
        await insertData(normalizedTitle, description);
        console.log(`Inserted ${normalizedTitle}: ${description} into database.`);
    }

    await client.end();
}

// Example usage
const words = [
    "слово",
    "время",
    "год",
    "человек",
    "день",
    "раз",
    "дело",
    "жизнь",
    "рука",
    "работа",
    "разница",
    "смысл",
    "часть",
    "конец",
    "вопрос",
    "сторона",
    "мир",
    "вид",
    "город",
    "сила",
    "лицо",
    "система",
    "закон",
    "минута",
    "мысль",
    "внимание",
    "опыт",
    "дорога",
    "место",
    "результат",
    "цель",
    "процесс",
    "решение",
    "книга",
    "голос",
    "свет",
    "чувство",
    "комната",
    "состояние",
    "развитие",
    "положение",
    "разговор",
    "область",
    "момент",
    "правило",
    "план",
    "возможность",
    "власть",
    "любовь",
    "помощь",
    "ответ",
    "действие",
    "причина",
    "информация",
    "программа",
    "компания",
    "душа",
    "необходимость",
    "факт",
    "предмет",
    "речь",
    "производство",
    "начальник",
    "телефон",
    "право",
    "ситуация",
    "товарищ",
    "отношение",
    "задача",
    "понимание",
    "успех",
    "материал",
    "форма",
    "неделя",
    "знание",
    "характер",
    "движение",
    "группа",
    "мнение",
    "число",
    "цена",
    "учеба",
    "совет",
    "болезнь",
    "рассказ",
    "пол",
    "интерес",
    "течение",
    "служба",
    "правда",
    "задание",
    "имя",
    "страх",
    "значение",
    "язык",
    "период",
    "метод",
    "влияние",
    "средство",
    "директор",
    "идея",
    "мера",
    "политика",
    "управление",
    "этап",
    "принцип",
    "строительство",
    "пример",
    "проблема",
    "врач",
    "механизм",
    "организация",
    "искусство",
    "поведение",
    "случай",
    "профессия",
    "поездка",
    "традиция",
    "название",
    "уровень",
    "статья",
    "выход",
    "планета",
    "позиция",
    "государство",
    "текст",
    "стиль",
    "возраст",
    "игра",
    "тема",
    "здоровье",
    "количество",
    "роль",
    "вариант",
    "подход",
    "вывод",
    "деятельность",
    "тренировка",
    "личность",
    "рынок",
    "сумма",
    "встреча",
    "фильм",
    "атмосфера",
    "картина",
    "площадь",
    "элемент",
    "проект",
    "порядок",
    "изменение",
    "перспектива",
    "предложение",
    "страна",
    "событие",
    "стоимость",
    "объем",
    "понятие",
    "труд",
    "больница"
];
processWords(words).catch(error => console.error('Error processing words:', error));
