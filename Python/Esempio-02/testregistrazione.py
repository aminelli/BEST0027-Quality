
from selenium import webdriver 

from selenium.webdriver.chrome.service import Service #importo il servizio 

from webdriver_manager.chrome import ChromeDriverManager #importo driver manager

from selenium.webdriver.common.by import By
import time

#dichiaro una variabile che funge da driver e che usa chrome come browser
#qui si sta inizializzando il driver che serve a collegare il nostro codice a chrome
driver = webdriver.Chrome(service = Service (ChromeDriverManager().install())) 

driver.maximize_window() #e qui diciamo di mettersi a tutto schermo

driver.get("http://testlogin.corso.com")

time.sleep(2) #aspetta 2 secondi prima di andare a dormire

anchor = driver.find_element(By.ID, "registazione") #qui recupera il link dell'oggetto
anchor.click() #qui simula il click sul tasto login

time.sleep(2) 

#qui stiamo testando l'inserimento dell'username
nome = driver.find_element(By.ID, "txtName")
nome.clear ()
nome.send_keys("Anna") #questo testa il testo che vuoi inerire nel campo username

cognome = driver.find_element(By.ID, "txtCognome")
cognome.clear ()
cognome.send_keys("Amendola")

Dt_Nascita = driver.find_element(By.ID, "txtData_Nascita")
Dt_Nascita.clear ()
Dt_Nascita.send_keys("10/10/2025")

Email = driver.find_element(By.ID, "txtEmail")
Email.clear ()
Email.send_keys("pippo@gmail.com")

#qui invece testo la password
password = driver.find_element(By.ID, "txtPassword")
password.clear()
password.send_keys("Anna2")

conferma_password = driver.find_element(By.ID, "txtConferma_Password")
conferma_password.clear ()
conferma_password.send_keys("Anna")

btnRegisterSuccess = driver.find_element(By.ID, "btnRegisterSuccess")
btnRegisterSuccess.click()

time.sleep(4)



print("Test Registration completato")

driver.quit() #per chiudere il browser che avevamo aperto prima