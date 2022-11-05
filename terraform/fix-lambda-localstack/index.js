
const sleep = (ms) => {
    return new Promise(resolve => setTimeout(resolve, ms));
}

exports.handler = async (event, context) => {
    await sleep(10)

    return Promise.resolve({
        statusCode: 200,
        headers: {'Content-Type': 'application/json'},
        body: "Hello World",
    });
};