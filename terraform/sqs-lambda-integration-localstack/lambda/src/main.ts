import axios from 'axios';

exports.handler = async (event, context) => {
  const body = {event: event, context: context}
  try {
    console.log(JSON.stringify(event));
    const axiosResponse = await axios.post(process.env.URL, body);
    console.log(JSON.stringify(axiosResponse));
    return {
      statusCode: 200,
      headers: {'Content-Type': 'application/json'},
      body: axiosResponse.data?.body || axiosResponse.data
    }
  } catch (e) {
    return {
      statusCode: 500,
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(e.message)
    }
  }
}