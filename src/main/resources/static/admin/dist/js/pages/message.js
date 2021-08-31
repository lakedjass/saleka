let messageData = [];
let date = new Date();
let body = document.querySelector("tbody");
const fetchMessage = async (date) =>{
    await fetch("http://localhost:8080/api/v1/message")
        .then((res) => res.json())
        .then((data) => (messageData = data));
    console.log(messageData);
}

const messageDisplay = async () => {
    await fetchMessage();
    body.innerHTML = messageData
        .map((message) => {
            let val = message.body;
            val = message.body.substring(0,7)
            return `
              <tr>
                <td>
                  <div class="icheck-primary">
                    <input type="checkbox" value="">
                    <label for="check1"></label>
                  </div>
                </td>
                <td class="mailbox-star"><a href="#"><i class="fas fa-star text-warning"></i></a></td>
                <td class="mailbox-name"><a href="read-mail.html">${message.client.name}</a></td>
                <td class="mailbox-subject"><b>${message.subject}</b> - ${val} ...
                </td>
                <td class="mailbox-attachment"><i class="fas fa-paperclip"></i></td>
                <td class="mailbox-date">${message.date}</td>
              </tr>
            `;
        })
        .join("");
};
messageDisplay();
setInterval(messageDisplay,60000);