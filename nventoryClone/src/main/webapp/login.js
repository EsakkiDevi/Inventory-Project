document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const form = event.target;
    const formData = new FormData(form);
    const data = Object.fromEntries(formData.entries());

    fetch(form.action, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            document.getElementById('message').textContent = 'Login successful!';
            // Redirect to dashboard on success
            // window.location.href = 'dashboard.html';
        } else {
            response.text().then(text => {
                document.getElementById('message').textContent = text;
            });
        }
    })
    .catch(error => {
        document.getElementById('message').textContent = 'An unexpected error occurred.';
        console.error('Error:', error);
    });
});