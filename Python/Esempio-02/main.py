
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

anchor = driver.find_element(By.ID, "linkLogin") #qui recupera il link dell'oggetto
anchor.click() #qui simula il click sul tasto login

time.sleep(2) 

#qui stiamo testando l'inserimento dell'username
username = driver.find_element(By.ID, "txtUserName")
username.clear ()
username.send_keys("Anna") #questo testa il testo che vuoi inerire nel campo username

#qui invece testo la password
password = driver.find_element(By.ID, "txtPassword")
password.clear()
password.send_keys("Anna2")

btnLogin = driver.find_element(By.ID, "btnLogin")
btnLogin.click()

time.sleep(4)



print("Test login completato")

driver.quit() #per chiudere il browser che avevamo aperto prima